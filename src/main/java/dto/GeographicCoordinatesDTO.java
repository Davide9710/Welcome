package dto;

import javax.validation.constraints.NotNull;

public record GeographicCoordinatesDTO(@NotNull String latitude,
                                       @NotNull String longitude) {
}
