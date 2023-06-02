package service;

import domain.Review;
import domain.Tour;
import domain.Tourist;
import dto.CreateReviewRequestDTO;
import mapper.CreateReviewRequestDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ReviewRepository;
import repository.TourRepository;
import repository.TouristRepository;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final TouristRepository touristRepository;
    private final TourRepository tourRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, TouristRepository touristRepository, TourRepository tourRepository) {
        this.reviewRepository = reviewRepository;
        this.touristRepository = touristRepository;
        this.tourRepository = tourRepository;
    }

    public Review createReview(CreateReviewRequestDTO createReviewRequestDTO){
        Review review = CreateReviewRequestDTOMapper.INSTANCE.convert(createReviewRequestDTO.title(),
                createReviewRequestDTO.stars(),
                createReviewRequestDTO.content());
        Tourist author = touristRepository.getById(createReviewRequestDTO.authorId());
        Tour tour = tourRepository.getById(createReviewRequestDTO.tourId());
        review.setAuthor(author);
        review.setTour(tour);
        return reviewRepository.save(review);
    }
}
