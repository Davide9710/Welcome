package service.bo;

import dto.bo.CreateUserRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import service.userstrategy.UserStrategy;
import service.userstrategy.UserStrategyFactory;

@Service
@RequiredArgsConstructor
public class UserServiceBO {
    private final UserStrategyFactory userStrategyFactory;
    private final PasswordEncoder passwordEncoder;

    public void create(CreateUserRequestDTO request){
        UserStrategy strategy = userStrategyFactory.findStrategy(request.role());
        strategy.create(request, passwordEncoder.encode(request.password()));
    }
}
