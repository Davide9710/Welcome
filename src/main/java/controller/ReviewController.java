package controller;

import domain.Review;
import dto.CreateReviewRequestDTO;
import dto.CreateReviewResponseDTO;
import dto.ReviewDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mapper.ReviewDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/create")
    public ResponseEntity<CreateReviewResponseDTO> create(CreateReviewRequestDTO createReviewRequestDTO){
        log.info("create Review, request {}", createReviewRequestDTO);
        Review review = reviewService.createReview(createReviewRequestDTO);
        ReviewDTO reviewDTO = ReviewDTOMapper.INSTANCE.convert(review);
        return ResponseEntity.ok(new CreateReviewResponseDTO(reviewDTO));
    }
}
