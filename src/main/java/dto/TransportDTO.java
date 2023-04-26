package dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public record TransportDTO(@PositiveOrZero(message = "TourStop cost must be greater than zero") Double transportCost,
                           String transportDuration,
                           @NotNull String transportType,
                           String transportDetails,
                           String transportOtherOptions) {
}
