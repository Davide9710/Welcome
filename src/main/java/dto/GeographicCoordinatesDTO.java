package dto;

import jakarta.validation.constraints.NotNull;

public record GeographicCoordinatesDTO(@NotNull Double latitude,
                                       @NotNull Double longitude) {
}
