package dto.response;

import dto.UserDTO;
import jakarta.validation.Valid;

public record AuthenticationResponseJwtDTO(String jwt, @Valid UserDTO user) {
}
