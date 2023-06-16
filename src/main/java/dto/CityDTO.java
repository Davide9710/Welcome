package dto;

import jakarta.validation.constraints.NotBlank;

public record CityDTO(@NotBlank String name) {
}
