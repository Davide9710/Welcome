package service.userstrategy;

import domain.Tourist;
import domain.User;
import dto.RegisterRequestDTO;
import dto.bo.CreateUserRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import repository.TouristRepository;
import value.Role;

import static value.Role.TOURIST;

@Component
@RequiredArgsConstructor
public class TouristStrategy implements UserStrategy{

    private final TouristRepository touristRepository;

    /**
     * Method that returns the Role of this strategy
     * @return the Role of this strategy
     */
    @Override
    public Role getRole() {
        return TOURIST;
    }

    /**
     * Method that register the user in the db
     * @param request the request DTO contains username, password and role
     * @param encodedPsw encoded password, that allow this strategy to not depend on the PasswordEncoder
     * @return return the saved user
     */
    @Override
    public User register(RegisterRequestDTO request, String encodedPsw) {
        Tourist tourist = new Tourist(request.email(), encodedPsw);
        tourist = touristRepository.save(tourist);
        return tourist;
    }

    /**
     * Method used for the BO services
     * @param request the request DTO contains username, password and role
     * @param encodedPsw encoded password, that allow this strategy to not depend on the PasswordEncoder
     */
    @Override
    public void create(CreateUserRequestDTO request, String encodedPsw) {
        register(new RegisterRequestDTO(request.email(), request.password(), getRole()), encodedPsw);
    }
}
