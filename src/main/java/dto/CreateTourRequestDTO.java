package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.List;

public record CreateTourRequestDTO(String title,
                                   CityRequestDTO city,
                                   ThemeDTO theme,
                                   List<TagRequestDTO> tags,
                                   @NotBlank String approxDuration,
                                   @PositiveOrZero(message = "Cost must be greater than zero") Double approxCost,
                                   List<TourStopDTO> stops) {
}
