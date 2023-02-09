package dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

public record CreateTourRequestDTO(String title,
                                   @NotNull Long cityId,
                                   ThemeDTO theme,
                                   List<TagDTO> tags,
                                   String approxDuration,
                                   @PositiveOrZero(message = "Cost must be greater than zero") Double approxCost,
                                   List<TourStopDTO> stops) {
}
