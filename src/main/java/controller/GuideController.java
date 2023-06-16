package controller;

import domain.Tour;
import dto.TourDTO;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import mapper.TourDTOMapper;
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
@RequiredArgsConstructor
public class GuideController {

    private final GuideService guideService;

    @GetMapping("/{guideId}/tours")
    public List<TourDTO> getTourByGuideId(@NotNull @PathVariable("guideId")  Long guideId,
                                          @PositiveOrZero @RequestParam("page") Integer page,
                                          @Positive @RequestParam("size") Integer size){
        List<Tour> tourList = guideService.getToursByGuideId(guideId, page, size);
        return TourDTOMapper.INSTANCE.convert(tourList);
    }
}
