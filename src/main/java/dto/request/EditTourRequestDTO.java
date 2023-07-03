package dto.request;


import dto.CityDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record EditTourRequestDTO(String title,
                                 Double approxCost,
                                 Integer approxDuration,
                                 CityDTO city) {
}
