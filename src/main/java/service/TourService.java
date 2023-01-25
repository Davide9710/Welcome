package service;

import domain.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TourRepository;

@Service
public class TourService {
    private final TourRepository tourRepository;

    @Autowired
    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }


    public Tour getTour(Long id) {
        return tourRepository.getById(id);
    }

    public Tour create(Tour tour) {
        return tourRepository.save(tour);
    }


}
