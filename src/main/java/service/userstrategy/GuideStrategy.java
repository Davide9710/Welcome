package service.userstrategy;

import domain.Guide;
import domain.Tourist;
import domain.User;
import dto.RegisterRequestDTO;
import dto.bo.CreateUserRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import repository.GuideRepository;
import value.Role;

import static value.Role.GUIDE;

@Component
@RequiredArgsConstructor
public class GuideStrategy implements UserStrategy{

    private final GuideRepository guideRepository;

    @Override
    public Role getRole() {
        return GUIDE;
    }

    @Override
    public User register(RegisterRequestDTO request, String encodedPsw) {
        Guide guide = new Guide(request.email(), encodedPsw);
        guide = guideRepository.save(guide);
        return guide;
    }

    @Override
    public void create(CreateUserRequestDTO request, String encodedPsw) {
        register(new RegisterRequestDTO(request.email(), request.password(), getRole()), encodedPsw);
    }
}
