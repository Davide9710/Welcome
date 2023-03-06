package dto;

import javax.validation.constraints.NotNull;

public record GeographicCoordinatesDTO(@NotNull Double latitude,
                                       @NotNull Double longitude) {
}
