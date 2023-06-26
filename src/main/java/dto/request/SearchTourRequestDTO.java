package dto.request;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;

import java.util.List;

/**
 * Here the validation isn't expressed because these filters are optional
 */
public record SearchTourRequestDTO(Long cityId,
                                   Integer maxDuration,
                                   String themeName,
                                   List<String> tagNames,
                                   @PositiveOrZero int pageNumber,
                                   @Positive int pageSize) {
    @Builder
    public SearchTourRequestDTO{}
}
