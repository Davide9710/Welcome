package dto;

import value.Role;

public record RegisterRequestDTO(String username, String password, Role role) {
}
