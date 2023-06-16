package service;

import domain.Tour;
import domain.Tourist;
import exception.TourNotFoundException;
import exception.TouristNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.TourRepository;
import repository.TouristRepository;

@Service
@RequiredArgsConstructor
public class TouristService {
    private final TouristRepository touristRepository;
    private final TourRepository tourRepository;

    public void markAsComplete(Long touristId, Long tourId) {
        Tourist tourist = touristRepository.findById(touristId).orElseThrow(TouristNotFoundException::new);
        Tour tour = tourRepository.findById(tourId).orElseThrow(TourNotFoundException::new);
        tourist.addTour(tour);
        touristRepository.save(tourist);
        tourRepository.save(tour);
    }
}
