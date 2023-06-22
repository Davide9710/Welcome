package controller;

import domain.Guide;
import domain.Tour;
import dto.EditGuideRequestDTO;
import dto.EditGuideResponseDTO;
import dto.TourDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import mapper.EditGuideResponseDTOMapper;
import mapper.TourDTOMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.GuideService;

import java.util.List;

@RestController
@RequestMapping(value = "/guide", produces = MediaType.APPLICATION_JSON_VALUE)
@Valid
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

    @PatchMapping("/{guideId}")
    public ResponseEntity<EditGuideResponseDTO> edit(@PathVariable("guideId") @NotNull Long guideId,
                                                     @RequestBody @Valid EditGuideRequestDTO editGuideRequestDTO){
        Guide guide = guideService.edit(guideId, editGuideRequestDTO);
        return ResponseEntity.ok(EditGuideResponseDTOMapper.INSTANCE.convert(guide));
    }
}
