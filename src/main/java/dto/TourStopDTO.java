package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.List;

public record TourStopDTO(@NotBlank String title,
                          @NotNull String name,
                          @NotBlank String description,
                          @PositiveOrZero(message = "TourStop cost must be greater than zero") Double cost,
                          @NotBlank String duration,
                          GeographicCoordinatesDTO coordinates,
                          TransportDTO transport,
                          List<String> images) {
}
