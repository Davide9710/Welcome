package dto.request;

import jakarta.validation.constraints.Email;

public record AuthenticationRequestDTO(@Email String email, String password) {
}
