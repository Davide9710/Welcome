package dto;

import jakarta.validation.constraints.NotNull;

public record TagRequestDTO(Long id,
                            @NotNull String name) {
}
