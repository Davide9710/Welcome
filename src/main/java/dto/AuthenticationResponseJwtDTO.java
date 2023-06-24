package dto;

import jakarta.validation.Valid;

public record AuthenticationResponseJwtDTO(String jwt, @Valid UserDTO user) {
}
