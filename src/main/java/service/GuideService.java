package service;

import domain.Guide;
import domain.Tour;
import dto.EditGuideRequestDTO;
import exception.notfound.GuideNotFoundException;
import lombok.RequiredArgsConstructor;
import mapper.EditGuideRequestDTOMapper;
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

    public Guide edit(Long guideId, EditGuideRequestDTO editGuideRequestDTO) {
        Guide guide = guideRepository.findById(guideId)
                .orElseThrow(() -> new GuideNotFoundException(guideId));
        guide = EditGuideRequestDTOMapper.INSTANCE.updateGuideFromDto(editGuideRequestDTO, guide);
        return guide;
    }
}
