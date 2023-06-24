package dto;

import jakarta.validation.Valid;
import value.Role;

public record RegisterRequestDTO(@Valid String email, String password, Role role) {
}
