package service.userstrategy;

import domain.User;
import dto.RegisterRequestDTO;
import value.Role;

public interface UserStrategy {
    Role getRole();
    User register(RegisterRequestDTO request, String encodedPsw);
}
