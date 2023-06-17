package service;

import domain.Tour;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import repository.GuideRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuideService {
    private final GuideRepository guideRepository;

    public List<Tour> getToursByGuideId(Long guideId, int page, int size) {
        return guideRepository.findTourByGuideId(guideId, PageRequest.of(page, size));
    }
}
