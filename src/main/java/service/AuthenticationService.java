package service;

import domain.User;
import dto.AuthenticationRequestDTO;
import dto.AuthenticationResponseJwtDTO;
import dto.RegisterRequestDTO;
import exception.notfound.UsernameNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import value.Role;

import static value.Constants.JWT;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponseJwtDTO register(RegisterRequestDTO request) {
        User user = User.builder()
                .email(request.username())
                .password(passwordEncoder.encode(request.password()))
                .role(request.role())
                .build();
        userRepository.save(user);
        return authenticate(new AuthenticationRequestDTO(request.username(), request.password()));
    }

    public AuthenticationResponseJwtDTO authenticate(AuthenticationRequestDTO request) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );
        User user = userRepository.findByEmail(request.username())
                .orElseThrow(() -> new UsernameNotFoundException("user not found, username " + request.username()));
        String jwt = jwtService.generateToken(authenticate);
        return new AuthenticationResponseJwtDTO(jwt, user);

    }

    public HttpHeaders putJwtInHttpHeaders(String jwt){
        HttpHeaders headers = new HttpHeaders();
        headers.add(JWT, jwt);
        return headers;
    }
}
