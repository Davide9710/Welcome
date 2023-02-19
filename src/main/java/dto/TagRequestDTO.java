package dto;

import javax.validation.constraints.NotNull;

public record TagRequestDTO(Long id,
                            @NotNull String name) {
}
