package service;

import domain.Role;
import domain.User;
import dto.AuthenticationRequestDTO;
import dto.AuthenticationResponseDTO;
import dto.RegisterRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    /*TODO Remove this comments
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponseDTO register(RegisterRequestDTO request){
        User user = User.builder()
                .email(request.username())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.TOURIST) //TODO come gestire i ruoli?
                .build();
        userRepository.save(user);
        String jwt = jwtService.generateToken(user);
        return new AuthenticationResponseDTO(jwt);
    }

    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );
        User user = userRepository.findByEmail(request.username())
                .orElseThrow(() -> new UsernameNotFoundException("user not found, username " + request.username()));
        String jwt = jwtService.generateToken(user);
        return new AuthenticationResponseDTO(jwt);

    }*/
}
