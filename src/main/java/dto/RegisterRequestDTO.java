package dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import value.Role;

public record RegisterRequestDTO(@Email String email, String password, Role role) {
}
