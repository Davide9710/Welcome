package dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import java.util.List;

public record CreateTourRequestDTO(String cityName,
                                   String theme,
                                   List<TagDTO> tags,
                                   @Min(value = 0, message = "Duration must be greater than zero") Long aproxDuration,
                                   @DecimalMin(value = "0", message = "Cost must be greater than zero") Double aproxCost,
                                   List<TourStopDTO> tourStops) {
}
