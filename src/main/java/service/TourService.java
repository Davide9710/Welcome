package service;

import domain.Tour;
import dto.EditTourRequestDTO;
import exception.TourNotPresentException;
import mapper.EditTourRequestDTOMapper;
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

    public Tour edit(Long id, EditTourRequestDTO editTourRequestDTO) throws TourNotPresentException {
        Tour byId = tourRepository.findById(id).orElseThrow(TourNotPresentException::new);
        byId = EditTourRequestDTOMapper.INSTANCE.updateTourFromDto(editTourRequestDTO, byId);
        return tourRepository.save(byId);
    }

    public void delete(Long id) {
        Tour byId = tourRepository.findById(id).orElseThrow(TourNotPresentException::new);
        byId.setTourStatus(Tour.TourStatus.DELETED);
        tourRepository.save(byId);
    }
}

