package dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TagRequestDTO(@NotNull Long id,
                            @NotBlank String name) {
}
