package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CityResponseDTO(@NotNull Long id, @NotBlank String name) {
}
