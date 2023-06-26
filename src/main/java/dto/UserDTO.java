package dto;

import jakarta.validation.constraints.Email;

public record UserDTO(@Email String email) {
}
