package service;

import domain.Tour;
import dto.request.EditTourRequestDTO;
import dto.request.SearchTourRequestDTO;
import exception.notfound.TourNotFoundException;
import lombok.RequiredArgsConstructor;
import mapper.tour.EditTourRequestDTOMapper;
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
    public Tour create(Tour tour) {
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
}

