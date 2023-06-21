package service.userstrategy;

import domain.Tourist;
import domain.User;
import dto.RegisterRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import repository.TouristRepository;
import value.Role;

import static value.Role.TOURIST;

@Component
@RequiredArgsConstructor
public class TouristStrategy implements UserStrategy{

    private final TouristRepository touristRepository;

    @Override
    public Role getRole() {
        return TOURIST;
    }

    @Override
    public User register(RegisterRequestDTO request, String encodedPsw) {
        Tourist tourist = new Tourist(request.username(), encodedPsw);
        tourist = touristRepository.save(tourist);
        return tourist;
    }
}
