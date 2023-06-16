package dto;

import jakarta.validation.constraints.NotNull;

public record CreateReviewRequestDTO(String title,
                                     @NotNull Double stars,
                                     String content,
                                     @NotNull Long authorId,
                                     @NotNull Long tourId) {
}
