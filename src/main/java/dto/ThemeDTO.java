package dto;

import jakarta.validation.constraints.NotBlank;

public record ThemeDTO(@NotBlank String name) {
}
