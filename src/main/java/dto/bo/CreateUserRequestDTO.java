package dto.bo;

import value.Role;

public record CreateUserRequestDTO(String username, String password, Role role) {
}
