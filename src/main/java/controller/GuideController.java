package controller;

import domain.Guide;
import domain.Tour;
import dto.request.EditGuideRequestDTO;
import dto.response.EditGuideResponseDTO;
import dto.response.GetTourByGuideIdResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import mapper.guide.EditGuideResponseDTOMapper;
import mapper.tour.TourDTOMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.GuideService;

import java.util.List;

/**
 * Controller that defined authentication's endpoint, reachable with GUIDE role
 */
@RestController
@RequestMapping(value = "/guide", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@PreAuthorize("hasRole('GUIDE')")
public class GuideController {

    private final GuideService guideService;

    /**
     * Get Endpoint that get all tours created by a guide
     * @param guideId logged guide id
     * @param page page number
     * @param size page size
     * @return pages list of tours
     */
    @GetMapping("/{guideId}/tours")
    @Operation(summary = "get tour by guide id paged")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Guide Not Found Exception"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<GetTourByGuideIdResponseDTO> getTourByGuideId(@NotNull @PathVariable("guideId") Long guideId,
                                                                        @PositiveOrZero @RequestParam("page") Integer page,
                                                                        @Positive @RequestParam("size") Integer size) {
        List<Tour> tourList = guideService.getToursByGuideId(guideId, page, size);
        return ResponseEntity.ok(new GetTourByGuideIdResponseDTO(TourDTOMapper.INSTANCE.convert(tourList)));
    }

    /**
     * Patch endpoint that partially edit the guide data
     * @param guideId the logged guide id
     * @param editGuideRequestDTO the data to be updated
     * @return Response Entity
     */
    @PutMapping("/{guideId}")
    @Operation(summary = "edit guide info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "GuideNotFoundException"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<EditGuideResponseDTO> edit(@PathVariable("guideId") @NotNull Long guideId,
                                                     @RequestBody @Valid EditGuideRequestDTO editGuideRequestDTO) {
        Guide guide = guideService.edit(guideId, editGuideRequestDTO);
        return ResponseEntity.ok(EditGuideResponseDTOMapper.INSTANCE.convert(guide));
    }
}
