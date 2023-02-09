package dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

public record TourStopDTO(String title,
                          @NotNull String name,
                          String description,
                          @PositiveOrZero(message = "TourStop cost must be greater than zero") Double cost,
                          GeographicCoordinatesDTO geographicCoordinatesDTO,
                          TransportDTO transportDTO,
                          List<ImageDTO> images) {
}
