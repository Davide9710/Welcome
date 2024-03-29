package service.bo;

import domain.User;
import dto.bo.CreateUserRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import service.userstrategy.UserStrategy;
import service.userstrategy.UserStrategyFactory;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceBO {
    private final UserRepository userRepository;
    private final UserStrategyFactory userStrategyFactory;
    private final PasswordEncoder passwordEncoder;

    /**
     * method that create a new user using the userStrategyFactory
     * @param request the data to be inserted in the user table
     */
    public void create(CreateUserRequestDTO request){
        UserStrategy strategy = userStrategyFactory.findStrategy(request.role());
        strategy.create(request, passwordEncoder.encode(request.password()));
    }

    /**
     * method that returns all the users
     * @return a list of users
     */
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
