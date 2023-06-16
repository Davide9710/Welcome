package controller;

import dto.MarkAsCompleteRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> markAsComplete(@RequestBody @Valid MarkAsCompleteRequestDTO request){
        touristService.markAsComplete(request.touristId(), request.tourId());
        return ResponseEntity.ok().build();
    }
}
