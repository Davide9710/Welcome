package controller;

import domain.Review;
import dto.CreateReviewRequestDTO;
import dto.CreateReviewResponseDTO;
import dto.ReviewDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mapper.ReviewDTOMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ReviewService;

/**
 * Controller used to manage reviews endpoints, it requires TOURIST role
 */
@RestController
@RequestMapping(value = "/review",
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
        produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@RequiredArgsConstructor
@PreAuthorize("hasRole('TOURIST')")
public class ReviewController {

    private final ReviewService reviewService;

    /**
     * Post Endpoint that create a new review from the given data
     * @param createReviewRequestDTO it contains the data from the review, the reviewed tour and the reviewer's id
     * @return the created Review, projected into a DTO
     */
    @PostMapping("/create")
    public ResponseEntity<CreateReviewResponseDTO> create(@RequestBody @Valid CreateReviewRequestDTO createReviewRequestDTO) {
        log.info("create Review, request {}", createReviewRequestDTO);
        Review review = reviewService.createReview(createReviewRequestDTO);
        ReviewDTO reviewDTO = ReviewDTOMapper.INSTANCE.convert(review);
        return ResponseEntity.ok(new CreateReviewResponseDTO(reviewDTO));
    }
}
