package service;

import domain.Review;
import domain.Tour;
import domain.Tourist;
import dto.CreateReviewRequestDTO;
import exception.notfound.TourNotFoundException;
import exception.notfound.TouristNotFoundException;
import lombok.RequiredArgsConstructor;
import mapper.CreateReviewRequestDTOMapper;
import org.springframework.stereotype.Service;
import repository.ReviewRepository;
import repository.TourRepository;
import repository.TouristRepository;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final TouristRepository touristRepository;
    private final TourRepository tourRepository;

    public Review createReview(CreateReviewRequestDTO createReviewRequestDTO){
        Review review = CreateReviewRequestDTOMapper.INSTANCE.convert(createReviewRequestDTO.title(),
                createReviewRequestDTO.stars(),
                createReviewRequestDTO.content());
        Tourist author = touristRepository.findById(createReviewRequestDTO.authorId())
                .orElseThrow(() -> new TouristNotFoundException(createReviewRequestDTO.authorId()));
        Tour tour = tourRepository.findById(createReviewRequestDTO.tourId())
                .orElseThrow(() -> new TourNotFoundException(createReviewRequestDTO.tourId()));
        tour.incrementNumberOfReviews();
        tourRepository.save(tour);
        review.setAuthor(author);
        review.setTour(tour);
        return reviewRepository.save(review);
    }
}
