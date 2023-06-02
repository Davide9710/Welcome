package dto;

public record CreateReviewRequestDTO(String title,
                                     Double stars,
                                     String content,
                                     Long authorId,
                                     Long tourId) {
}
