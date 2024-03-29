package dto.request;

import jakarta.validation.constraints.Email;

public record LoginRequestDTO(@Email String email,
                              String password) {
}
