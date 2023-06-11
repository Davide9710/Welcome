package controller;

import domain.Tour;
import dto.TourDTO;
import mapper.TourDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.GuideService;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController
@RequestMapping(value = "/guide", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class GuideController {

    private final GuideService guideService;

    @Autowired
    public GuideController(GuideService guideService) {
        this.guideService = guideService;
    }

    @GetMapping("/{guideId}/tours")
    public List<TourDTO> getTourByGuideId(@PathVariable("guideId") Long guideId,
                                          @PositiveOrZero @RequestParam("page") Integer page,
                                          @Positive @RequestParam("size") Integer size){
        List<Tour> tourList = guideService.getToursByGuideId(guideId, page, size);
        return TourDTOMapper.INSTANCE.convert(tourList);
    }
}
