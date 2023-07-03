package service;

import domain.Guide;
import domain.Tour;
import dto.request.EditGuideRequestDTO;
import exception.notfound.GuideNotFoundException;
import lombok.RequiredArgsConstructor;
import mapper.guide.EditGuideRequestDTOMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import repository.GuideRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuideService {
    private final GuideRepository guideRepository;

    /**
     * Method that return the tour owned by the guide, usign a pageable request
     * @param guideId the id of the guide
     * @param page page number
     * @param size page size
     * @return the list of tours
     */
    public List<Tour> getToursByGuideId(Long guideId, int page, int size) {
        if(!guideRepository.existsById(guideId)){
            throw new GuideNotFoundException(guideId);
        }
        return guideRepository.findTourByGuideId(guideId, PageRequest.of(page, size));
    }

    /**
     * method that update the guide information: organization name and selected city
     * @param guideId the id of the requesting guide
     * @param editGuideRequestDTO the data to be updated
     * @return the guide updated
     */
    public Guide edit(Long guideId, EditGuideRequestDTO editGuideRequestDTO) {
        Guide guide = guideRepository.findById(guideId)
                .orElseThrow(() -> new GuideNotFoundException(guideId));
        guide = EditGuideRequestDTOMapper.INSTANCE.updateGuideFromDto(editGuideRequestDTO, guide);
        return guide;
    }
}
