package dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record EditTourRequestDTO(@NotBlank String title,
                                 @NotNull Double approxCost,
                                 @NotNull Integer approxDuration,
                                 CityDTO city,
                                 List<TagRequestDTO> tags) {
}
