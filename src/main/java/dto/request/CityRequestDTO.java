package dto.request;

import jakarta.validation.constraints.NotNull;

public record CityRequestDTO(@NotNull Long id) {
}
