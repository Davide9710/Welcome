package service;

import domain.Tour;
import dto.EditTourRequestDTO;
import dto.SearchTourRequestDTO;
import exception.TourNotFoundException;
import lombok.RequiredArgsConstructor;
import mapper.EditTourRequestDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import repository.TourRepository;
import specification.SearchTourSpecification;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourService {
    private final TourRepository tourRepository;

    public Tour getTour(Long id) {
        return tourRepository.findById(id)
                .orElseThrow(() -> new TourNotFoundException(id));
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

    public Tour edit(Long id, EditTourRequestDTO editTourRequestDTO) throws TourNotFoundException {
        Tour byId = tourRepository.findById(id).orElseThrow(() -> new TourNotFoundException(id));
        byId = EditTourRequestDTOMapper.INSTANCE.updateTourFromDto(editTourRequestDTO, byId);
        return tourRepository.save(byId);
    }

    public void delete(Long id) {
        tourRepository.deleteById(id);
    }

    public List<Tour> search(SearchTourRequestDTO searchTourRequestDTO) {
        SearchTourSpecification specification = new SearchTourSpecification(searchTourRequestDTO);
        //TODO qui il paging come lo gestiamo?
        //TODO ordina i risultati
        PageRequest of = PageRequest.of(0, 10, Sort.by("rating").descending().and(Sort.by("reviews")));
        Page<Tour> tours = tourRepository.findAll(specification, of);
        return tours.getContent();
    }
}

