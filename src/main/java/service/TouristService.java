package service;

import domain.Tour;
import domain.Tourist;
import dto.request.EditTouristRequestDTO;
import exception.notfound.TourNotFoundException;
import exception.notfound.TouristNotFoundException;
import lombok.RequiredArgsConstructor;
import mapper.tourist.EditTouristRequestDTOMapper;
import org.springframework.stereotype.Service;
import repository.TourRepository;
import repository.TouristRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TouristService {
    private final TouristRepository touristRepository;
    private final TourRepository tourRepository;

    /**
     * Method that a user call to mark a tour as completed and to add it to his profile
     * @param touristId the id of the logged tourist
     * @param tourId the id of the tour to be marked
     */
    public void markAsComplete(Long touristId, Long tourId) {
        Tourist tourist = touristRepository.findById(touristId)
                .orElseThrow(() -> new TouristNotFoundException(touristId));
        Tour tour = tourRepository.findById(tourId)
                .orElseThrow(() -> new TourNotFoundException(tourId));
        tourist.addTour(tour);
        touristRepository.save(tourist);
        tourRepository.save(tour);
    }

    /**
     * method that allow the tourist to update his personal information: firstName and lastName
     * @param touristId the id of the logged user
     * @param requestDTO the firstName and lastName
     * @return the updated tourist
     */
    public Tourist edit(Long touristId, EditTouristRequestDTO requestDTO) {
        Tourist tourist = touristRepository.findById(touristId)
                .orElseThrow(() -> new TouristNotFoundException(touristId));
        tourist = EditTouristRequestDTOMapper.INSTANCE.updateTouristFromDto(requestDTO, tourist);
        touristRepository.save(tourist);
        return tourist;
    }

    /**
     * method that return all the tour marked by the tourist as completed, to show in the personal profile
     * @param touristId the id of the logged tourist
     * @return the list of tour
     */
    public List<Tour> getAllMarkedTour(Long touristId) {
        return touristRepository.findById(touristId).orElseThrow(() -> new TouristNotFoundException(touristId))
                .getTours();
    }
}
