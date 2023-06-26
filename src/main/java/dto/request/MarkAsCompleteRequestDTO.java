package dto.request;

import jakarta.validation.constraints.NotNull;

public record MarkAsCompleteRequestDTO(@NotNull Long touristId, @NotNull Long tourId) {
}
