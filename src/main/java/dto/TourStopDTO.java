package dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.List;

public record TourStopDTO(String title,
                          @NotNull String name,
                          String description,
                          @PositiveOrZero(message = "TourStop cost must be greater than zero") Double cost,
                          String duration,
                          GeographicCoordinatesDTO coordinates,
                          TransportDTO transport,
                          List<String> images) {
}
