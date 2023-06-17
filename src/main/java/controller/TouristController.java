package controller;

import domain.Tourist;
import dto.EditTouristRequestDTO;
import dto.EditTouristResponseDTO;
import dto.MarkAsCompleteRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import mapper.EditTouristResponseDTOMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.TouristService;

@RestController
@RequestMapping(value = "/tourist", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TouristController {
    private final TouristService touristService;

    @PostMapping("/mark-as-complete")
    public ResponseEntity<?> markAsComplete(@RequestBody @Valid MarkAsCompleteRequestDTO request) {
        touristService.markAsComplete(request.touristId(), request.tourId());
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{touristId}")
    public ResponseEntity<EditTouristResponseDTO> edit(@PathVariable("touristId") @NotNull Long touristId,
                                                       @RequestBody @Valid EditTouristRequestDTO requestDTO) {
        Tourist tourist = touristService.edit(touristId, requestDTO);
        return ResponseEntity.ok(EditTouristResponseDTOMapper.INSTANCE.convert(tourist));
    }
}
