package service;

import domain.Tourist;
import domain.User;
import dto.AuthenticationRequestDTO;
import dto.AuthenticationResponseJwtDTO;
import dto.RegisterRequestDTO;
import exception.notfound.UsernameNotFoundException;
import lombok.RequiredArgsConstructor;
import mapper.AuthenticationResponseJwtDTOMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import repository.TouristRepository;
import repository.UserRepository;

import static value.Constants.JWT;
import static value.Role.TOURIST;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TouristRepository touristRepository;

    public AuthenticationResponseJwtDTO register(RegisterRequestDTO request) {
        Tourist tourist = new Tourist(request.username(), passwordEncoder.encode(request.password()));
        tourist = touristRepository.save(tourist);
        String jwt = jwtService.generateToken(tourist);
        return AuthenticationResponseJwtDTOMapper.INSTANCE.convert(jwt, tourist);
    }

    public AuthenticationResponseJwtDTO authenticate(AuthenticationRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );
        User user = userRepository.findByEmail(request.username())
                .orElseThrow(() -> new UsernameNotFoundException("user not found, username " + request.username()));
        String jwt = jwtService.generateToken(user);
        return AuthenticationResponseJwtDTOMapper.INSTANCE.convert(jwt, user);
    }

    public HttpHeaders putJwtInHttpHeaders(String jwt){
        HttpHeaders headers = new HttpHeaders();
        headers.add(JWT, jwt);
        return headers;
    }
}
