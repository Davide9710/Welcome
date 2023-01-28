package service;

import domain.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import repository.GuideRepository;

import java.util.List;

@Service
public class GuideService {
    private final GuideRepository guideRepository;

    @Autowired
    public GuideService(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    public List<Tour> getToursByGuideId(Long guideId, int page, int size) {
        return guideRepository.findTourByGuideId(guideId, PageRequest.of(page, size));
    }
}
