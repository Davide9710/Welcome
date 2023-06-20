package dto;

import domain.User;

public record AuthenticationResponseJwtDTO(String jwt, UserDTO user) {
}
