package controller;

import domain.Tour;
import domain.Tourist;
import dto.EditTouristRequestDTO;
import dto.EditTouristResponseDTO;
import dto.MarkAsCompleteRequestDTO;
import dto.MarkedToursResponseDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import mapper.EditTouristResponseDTOMapper;
import mapper.TourDTOMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
 * Controller that contains all the tourist related endpoints
 */
@RestController
@RequestMapping(value = "/tourist", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TouristController {
    private final TouristService touristService;

    /**
     * Post endpoint that mark a tour as completed by logged user
     * @param request tour and tourist id
     * @return Response Entity indicating the operation result
     */
    @PostMapping("/mark-tour-as-complete")
    public ResponseEntity<?> markAsComplete(@RequestBody @Valid MarkAsCompleteRequestDTO request) {
        touristService.markAsComplete(request.touristId(), request.tourId());
        return ResponseEntity.ok().build();
    }

    /**
     * Get Endpoint that returns all the marked tour by the logged user
     * @param touristId logged user id
     * @return the marked tours
     */
    @GetMapping("/{touristId}/marked-tours")
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
    @PatchMapping("/{touristId}")
    public ResponseEntity<EditTouristResponseDTO> edit(@PathVariable("touristId") @NotNull Long touristId,
                                                       @RequestBody @Valid EditTouristRequestDTO requestDTO) {
        Tourist tourist = touristService.edit(touristId, requestDTO);
        return ResponseEntity.ok(EditTouristResponseDTOMapper.INSTANCE.convert(tourist));
    }
}
