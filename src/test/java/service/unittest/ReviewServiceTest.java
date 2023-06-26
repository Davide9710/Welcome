package service.unittest;

import domain.Review;
import domain.Tour;
import domain.Tourist;
import dto.request.CreateReviewRequestDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import repository.ReviewRepository;
import repository.TourRepository;
import repository.TouristRepository;
import service.ReviewService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@SpringBootTest
public class ReviewServiceTest {
    @SpringBootConfiguration
    static class TestConfig {
        @Autowired
        ReviewRepository reviewRepository;
        @Autowired
        TouristRepository touristRepository;
        @Autowired
        TourRepository tourRepository;

        @Bean
        public ReviewService reviewService() {
            return new ReviewService(reviewRepository, touristRepository, tourRepository);
        }
    }

    @MockBean
    ReviewRepository reviewRepository;
    @MockBean
    TouristRepository touristRepository;
    @MockBean
    TourRepository tourRepository;

    @Autowired
    ReviewService reviewService;

    @Test
    public void createReviewTest() {
        //given
        Tourist mockAuthor = new Tourist();
        String mockAuthorEmail = "mockAuthorEmail";
        mockAuthor.setEmail(mockAuthorEmail);
        Mockito.when(touristRepository.findById(anyLong())).thenReturn(Optional.of(mockAuthor));
        Tour mockTour = new Tour();
        String mockTourTitle = "mockTourTitle";
        mockTour.setTitle(mockTourTitle);

        Mockito.when(tourRepository.findById(anyLong())).thenReturn(Optional.of(mockTour));
        Mockito.when(touristRepository.save(any())).thenReturn(null);
        Mockito.when(tourRepository.save(any())).thenReturn(null);
        Review mockReview = new Review();
        String mockReviewTitle = "mockReviewTitle";
        mockReview.setTitle(mockReviewTitle);
        Mockito.when(reviewRepository.save(any())).thenReturn(mockReview);

        Double mockStars = 4D;
        String mockContent = "mockContent";
        Long mockAuthorId = 1L;
        Long mockTourId = 1L;
        CreateReviewRequestDTO createReviewRequestDTO = new CreateReviewRequestDTO(
                mockReviewTitle,
                mockStars,
                mockContent,
                mockAuthorId,
                mockTourId
        );

        //when
        Review review = reviewService.createReview(createReviewRequestDTO);

        //then
        assertNotNull(review);
        assertEquals(review.getTitle(), mockReviewTitle);
    }
}
