package dto.request;

import jakarta.validation.constraints.NotBlank;

public record EditTouristRequestDTO(@NotBlank String firstName, @NotBlank String lastName) {
}
