package dto;

import jakarta.validation.constraints.NotBlank;

public record ThemeResponseDTO(@NotBlank String name) {
}
