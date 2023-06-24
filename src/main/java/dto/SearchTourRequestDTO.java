package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record SearchTourRequestDTO(@NotNull Long cityId,
                                   @NotNull Integer maxDuration,
                                   @NotBlank String themeName,
                                   List<@NotBlank String> tagNames,
                                   @Positive int pageNumber,
                                   @Positive int pageSize) {
}
