package dto;

import jakarta.validation.Valid;

import java.util.List;

public record GetAllThemeResponseDTO(@Valid List<ThemeResponseDTO> themes) {
}
