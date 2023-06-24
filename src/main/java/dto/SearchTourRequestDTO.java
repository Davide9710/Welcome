package dto;

import jakarta.validation.constraints.Positive;

import java.util.List;

/**
 * Here the validation isn't expressed because these filters are optional
 */
public record SearchTourRequestDTO(Long cityId,
                                   Integer maxDuration,
                                   String themeName,
                                   List<String> tagNames,
                                   @Positive int pageNumber,
                                   @Positive int pageSize) {
}
