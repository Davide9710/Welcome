package dto;

import javax.validation.constraints.PositiveOrZero;
import java.util.List;

public record CreateTourRequestDTO(String title,
                                   CityRequestDTO cityRequestDTO,
                                   ThemeDTO theme,
                                   List<TagRequestDTO> tags,
                                   String approxDuration,
                                   @PositiveOrZero(message = "Cost must be greater than zero") Double approxCost,
                                   List<TourStopDTO> stops) {
}
