package dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

public record CreateTourRequestDTO(@NotNull String cityName,
                                   String theme,
                                   List<TagDTO> tags,
                                   @Positive(message = "Duration must be greater than zero") Long aproxDuration,
                                   @PositiveOrZero(message = "Cost must be greater than zero") Double aproxCost,
                                   List<TourStopDTO> tourStops) {
}
