package controller;

import dto.CreateReviewRequestDTO;
import dto.CreateReviewResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ReviewService;

@RestController
@RequestMapping(value = "/review",
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
        produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class ReviewController {
    //private final ReviewService reviewService;

    @PostMapping("/create")
    public ResponseEntity<CreateReviewResponseDTO> create(CreateReviewRequestDTO createReviewRequestDTO){
        return null;
    }
}
