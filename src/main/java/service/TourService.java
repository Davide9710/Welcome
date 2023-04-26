package service;

import domain.Tour;
import dto.EditTourRequestDTO;
import dto.SearchTourRequestDTO;
import exception.TourNotPresentException;
import mapper.EditTourRequestDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.ImageRepository;
import repository.TagRepository;
import repository.ThemeRepository;
import repository.TourRepository;
import repository.TourStopRepository;
import specification.SearchTourSpecification;

import java.util.List;

@Service
public class TourService {
    private final TourRepository tourRepository;
    private final TagRepository tagRepository;
    private final ThemeRepository themeRepository;
    private final TourStopRepository tourStopRepository;
    private final ImageRepository imageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TagRepository tagRepository, ThemeRepository themeRepository, TourStopRepository tourStopRepository, ImageRepository imageRepository) {
        this.tourRepository = tourRepository;
        this.tagRepository = tagRepository;
        this.themeRepository = themeRepository;
        this.tourStopRepository = tourStopRepository;
        this.imageRepository = imageRepository;
    }


    public Tour getTour(Long id) {
        return tourRepository.findById(id)
                .orElseThrow(TourNotPresentException::new);
    }

    /*public Tour create(Tour tour) {
        //All tags without id are NEW tags, so they need to be saved before
        tour.getTags().stream()
                .filter(tag -> tag.getId() == null)
                .forEach(tagRepository::save);

        tour.getTags().forEach(tag -> tag.addTour(tour));

        //If the theme has no id, it means it is a new theme, so it needs to be saved before
        if(tour.getTheme().getId() == null){
            themeRepository.save(tour.getTheme());
        }

        imageRepository.saveAll(tour.getStops().stream().flatMap(tourStop -> tourStop.getImages().stream()).toList());

        tourStopRepository.saveAll(tour.getStops());

        return tourRepository.save(tour);
    }*/

    public Tour create(Tour tour) {
        return tourRepository.save(tour);
    }

    public Tour edit(Long id, EditTourRequestDTO editTourRequestDTO) throws TourNotPresentException {
        Tour byId = tourRepository.findById(id).orElseThrow(TourNotPresentException::new);
        byId = EditTourRequestDTOMapper.INSTANCE.updateTourFromDto(editTourRequestDTO, byId);
        return tourRepository.save(byId);
    }

    public void delete(Long id) {
        Tour byId = tourRepository.findById(id).orElseThrow(TourNotPresentException::new);
        byId.setStatus(Tour.TourStatus.DELETED);
        tourRepository.save(byId);
    }

    public List<Tour> search(SearchTourRequestDTO searchTourRequestDTO) {
        SearchTourSpecification specification = new SearchTourSpecification(searchTourRequestDTO);
        //TODO qui il paging come lo gestiamo?
        Page<Tour> tours = tourRepository.findAll(specification, Pageable.ofSize(10));
        return tours.getContent();
    }
}

