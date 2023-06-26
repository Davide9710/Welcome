package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//City selected by the used on a selector
public record SelectedCityDTO(@NotNull Long id, @NotBlank String name) {
}
