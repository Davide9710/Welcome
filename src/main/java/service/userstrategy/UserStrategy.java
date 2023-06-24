package service.userstrategy;

import domain.User;
import dto.RegisterRequestDTO;
import dto.bo.CreateUserRequestDTO;
import value.Role;

/**
 * This interface implements the strategy pattern to manage different behavior based on the user's Role
 */
public interface UserStrategy {
    Role getRole();
    User register(RegisterRequestDTO request, String encodedPsw);
    void create(CreateUserRequestDTO request, String encode);
}
