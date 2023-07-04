package controller;

import domain.Tour;
import domain.Tourist;
import dto.request.EditTouristRequestDTO;
import dto.response.EditTouristResponseDTO;
import dto.request.MarkAsCompleteRequestDTO;
import dto.response.MarkedToursResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import mapper.tourist.EditTouristResponseDTOMapper;
import mapper.tour.TourDTOMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.TouristService;

import java.util.List;

/**
 * Controller that contains all the tourist related endpoints, it requires TOURIST role
 */
@RestController
@RequestMapping(value = "/tourist")
@RequiredArgsConstructor
@PreAuthorize("hasRole('TOURIST')")
public class TouristController {
    private final TouristService touristService;

    /**
     * Post endpoint that mark a tour as completed by logged user
     * @param request tour and tourist id
     */
    @PostMapping("/mark-as-completed")
    @Operation(summary = "mark tour as completed")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "ResourceNotFound"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<?> markAsComplete(@RequestBody @Valid MarkAsCompleteRequestDTO request) {
        touristService.markAsComplete(request.touristId(), request.tourId());
        return ResponseEntity.ok().build();
    }

    /**
     * Get Endpoint that returns all the marked tour by the logged user
     * @param touristId logged user id
     * @return the marked tours
     */
    @GetMapping(path = "/{touristId}/marked-tours", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "get all marked tours")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "TouristNotFoundException"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<MarkedToursResponseDTO> getAllMarkedTour(@PathVariable("touristId") @NotNull Long touristId) {
        List<Tour> allMarkedTour = touristService.getAllMarkedTour(touristId);
        return ResponseEntity.ok(new MarkedToursResponseDTO(TourDTOMapper.INSTANCE.convert(allMarkedTour)));
    }

    /**
     * Patch endpoint that allows the tourist to partially update his info
     * @param touristId id of the logged tourist
     * @param requestDTO data to be saved
     * @return the updated tourist
     */
    @PatchMapping(path = "/{touristId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "edit tourist")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "TouristNotFoundException"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<EditTouristResponseDTO> edit(@PathVariable("touristId") @NotNull Long touristId,
                                                       @RequestBody @Valid EditTouristRequestDTO requestDTO) {
        Tourist tourist = touristService.edit(touristId, requestDTO);
        return ResponseEntity.ok(EditTouristResponseDTOMapper.INSTANCE.convert(tourist));
    }
}
