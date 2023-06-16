package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record TransportDTO(@PositiveOrZero(message = "TourStop cost must be greater than zero") Double transportCost,
                           @NotBlank String transportDuration,
                           @NotNull String transportType,
                           @NotBlank String transportDetails,
                           @NotBlank String transportOtherOptions) {
}
