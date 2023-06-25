package service;

import domain.PlatformUser;
import exception.PlatformUserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.PlatformUserRepository;

@Service
@RequiredArgsConstructor
public class PlatformUserService {
    private final PlatformUserRepository platformUserRepository;

    public PlatformUser getPlatformUserById(Long id) {
        return platformUserRepository.findById(id).orElseThrow(
                () -> new PlatformUserNotFoundException(id)
        );
    }
}
