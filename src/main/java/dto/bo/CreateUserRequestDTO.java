package dto.bo;

import value.Role;

public record CreateUserRequestDTO(String email, String password, Role role) {
}
