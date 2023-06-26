package dto.request;

import jakarta.validation.constraints.Email;

public record ResetPasswordRequestDTO(@Email String email) {
}
