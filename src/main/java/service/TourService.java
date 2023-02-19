package service;

import domain.Image;
import domain.Tag;
import domain.Tour;
import domain.TourStop;
import dto.EditTourRequestDTO;
import exception.TourNotPresentException;
import mapper.EditTourRequestDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ImageRepository;
import repository.TagRepository;
import repository.ThemeRepository;
import repository.TourRepository;
import repository.TourStopRepository;

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
        return tourRepository.findById(id).orElseThrow(TourNotPresentException::new);
    }

    public Tour create(Tour tour) {
        tour.getTags().stream()
                .filter(tag -> tag.getId() != null)
                .forEach(tag -> tag.addTour(tour));
        tagRepository.saveAll(tour.getTags());

        themeRepository.save(tour.getTheme());

        imageRepository.saveAll(tour.getStops().stream().flatMap(tourStop -> tourStop.getImages().stream()).toList());

        tourStopRepository.saveAll(tour.getStops());

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

