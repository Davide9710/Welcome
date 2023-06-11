package dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record TransportDTO(@PositiveOrZero(message = "TourStop cost must be greater than zero") Double transportCost,
                           String transportDuration,
                           @NotNull String transportType,
                           String transportDetails,
                           String transportOtherOptions) {
}
