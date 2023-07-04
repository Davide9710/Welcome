package service;

import domain.City;
import domain.Guide;
import domain.Tag;
import domain.Theme;
import domain.Tour;
import domain.softdeletable.SoftDelete;
import domain.elastic.TourDocument;
import domain.softdeletable.SoftDelete;
import dto.request.EditTourRequestDTO;
import dto.request.SearchTourRequestDTO;
import exception.CityNotFoundException;
import exception.notfound.GuideNotFoundException;
import exception.notfound.TourNotFoundException;
import lombok.RequiredArgsConstructor;
import mapper.tour.EditTourRequestDTOMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import repository.CityRepository;
import repository.GuideRepository;
import repository.SoftDeleteRepository;
import repository.TagRepository;
import repository.ThemeRepository;
import repository.TourRepository;
import elastic.TourRepositoryFullText;
import specification.SearchTourSpecification;
import value.Status;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TourService {
    private final TourRepository tourRepository;
    private final GuideRepository guideRepository;
    private final CityRepository cityRepository;
    private final TagRepository tagRepository;
    private final ThemeRepository themeRepository;
    private final SoftDeleteRepository softDeleteRepository;
    private final TourRepositoryFullText tourRepositoryFullText;

    /**
     * method that return a tour by its id
     * @param id the tour id
     * @return the Tour object from the db
     */
    public Tour getTour(Long id) {
        return tourRepository.findById(id)
                .orElseThrow(() -> new TourNotFoundException(id));
    }

    /**
     * save the tour object to the db
     * @param tour tour object
     * @return the saved tour
     */
    public Tour create(Tour tour, Long guideId) {
        Guide guide = guideRepository.findById(guideId).orElseThrow(() -> new GuideNotFoundException(guideId));
        tour.setGuide(guide);
        City city = cityRepository.findById(tour.getCity().getId())
                .orElseThrow(() -> new CityNotFoundException(tour.getCity().getId()));
        tour.setCity(city);
        List<Tag> tags = tour.getTags().stream().map(tagName -> {
            Optional<Tag> tag = tagRepository.findByName(tagName.getName());
            return tag.orElseGet(() -> tagRepository.save(tagName));
        }).toList();

        Optional<Theme> theme = themeRepository.findByName(tour.getTheme().getName());
        Theme tourTheme = theme.orElseGet(() -> themeRepository.save(tour.getTheme()));
        SoftDelete softDelete = new SoftDelete();
        softDelete.setStatus(Status.ACTIVE);
        softDelete = softDeleteRepository.save(softDelete);

        tour.setTheme(tourTheme);
        tour.setTags(tags);
        tour.setSoftDelete(softDelete);
        return tourRepository.save(tour);
    }

    /**
     * Method that allows the guide to edit a tour, changing basic information
     * @param tourId the is of the tour to be changed
     * @param editTourRequestDTO data to be updated
     * @return the updated tour
     * @throws TourNotFoundException if the tour with id = tourId is not found
     */
    public Tour edit(Long tourId, EditTourRequestDTO editTourRequestDTO) throws TourNotFoundException {
        Tour tour = tourRepository.findById(tourId).orElseThrow(() -> new TourNotFoundException(tourId));
        tour = EditTourRequestDTOMapper.INSTANCE.updateTourFromDto(editTourRequestDTO, tour);
        return tourRepository.save(tour);
    }

    /**
     * method that delete the given tour
     * @param id the id of the tour to be deleted
     */
    public void delete(Long id) {
        tourRepository.deleteById(id);
    }

    /**
     * method that allow the user to efficiently search tour with optional filter; the list is ordered by the average rating,
     * obtained through reviews, and by number of reviews
     * @param searchTourRequestDTO optional filters
     * @return the list of the found tours
     */
    public List<Tour> search(SearchTourRequestDTO searchTourRequestDTO) {
        SearchTourSpecification specification = new SearchTourSpecification(searchTourRequestDTO);
        PageRequest of = PageRequest.of(searchTourRequestDTO.pageNumber(),
                searchTourRequestDTO.pageSize(),
                Sort.by("rating").descending().and(Sort.by("numberOfReviews")));
        Page<Tour> tours = tourRepository.findAll(specification, of);
        return tours.getContent();
    }

    public List<TourDocument> searchText(String text) {
        return tourRepositoryFullText.searchByTitleFullText(text);
    }

    public List<TourDocument> searchByTourNamesText(String text) {
        return tourRepositoryFullText.searchByTourStopNames(text);
    }

    public void test() {
        TourDocument tourDocument = TourDocument.builder()
                .title("title")
                .tourStopNames(List.of("Colosseum", "San Pietro", "San Giovanni in Laterano"))
                .build();
        tourRepositoryFullText.save(tourDocument);
    }
}

