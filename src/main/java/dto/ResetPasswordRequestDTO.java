package dto;

import jakarta.validation.constraints.Email;
import lombok.Builder;

public record ResetPasswordRequestDTO(@Email String email) {
}
