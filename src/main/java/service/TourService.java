package service;

import domain.Tag;
import domain.Tour;
import dto.EditTourRequestDTO;
import exception.TourNotPresentException;
import mapper.EditTourRequestDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TagRepository;
import repository.TourRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TourService {
    private final TourRepository tourRepository;
    private final TagRepository tagRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TagRepository tagRepository) {
        this.tourRepository = tourRepository;
        this.tagRepository = tagRepository;
    }


    public Tour getTour(Long id) {
        return tourRepository.findById(id).orElseThrow(TourNotPresentException::new);
    }

    public Tour create(Tour tour) {
        List<Tag> tags = tour.getTags().stream().filter(tag -> tag.getId() != null).toList();
        tags.forEach(tag -> {
            tag.addTour(tour);
            tagRepository.save(tag);
        });
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

