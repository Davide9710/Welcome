package service;

import domain.Tour;
import domain.Tourist;
import dto.EditTouristRequestDTO;
import exception.TourNotFoundException;
import exception.TouristNotFoundException;
import lombok.RequiredArgsConstructor;
import mapper.EditTouristRequestDTOMapper;
import org.springframework.stereotype.Service;
import repository.TourRepository;
import repository.TouristRepository;

@Service
@RequiredArgsConstructor
public class TouristService {
    private final TouristRepository touristRepository;
    private final TourRepository tourRepository;

    public void markAsComplete(Long touristId, Long tourId) {
        Tourist tourist = touristRepository.findById(touristId)
                .orElseThrow(() -> new TouristNotFoundException(touristId));
        Tour tour = tourRepository.findById(tourId)
                .orElseThrow(() -> new TourNotFoundException(tourId));
        tourist.addTour(tour);
        touristRepository.save(tourist);
        tourRepository.save(tour);
    }

    public Tourist edit(Long touristId, EditTouristRequestDTO requestDTO) {
        Tourist tourist = touristRepository.findById(touristId)
                .orElseThrow(() -> new TouristNotFoundException(touristId));
        tourist = EditTouristRequestDTOMapper.INSTANCE.updateTouristFromDto(requestDTO, tourist);
        return tourist;
    }
}
