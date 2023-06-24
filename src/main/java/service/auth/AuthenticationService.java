package service.auth;

import domain.User;
import dto.AuthenticationRequestDTO;
import dto.AuthenticationResponseJwtDTO;
import dto.RegisterRequestDTO;
import dto.ResetPasswordRequestDTO;
import exception.notfound.EmailNotFoundException;
import lombok.RequiredArgsConstructor;
import mapper.AuthenticationResponseJwtDTOMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import service.mailing.EmailService;
import service.userstrategy.UserStrategy;
import service.userstrategy.UserStrategyFactory;
import utils.RandomValues;

import static value.Constants.JWT;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserStrategyFactory userStrategyFactory;
    private final EmailService emailService;

    /**
     * Method that register a user, given his credentials and role using the userStrategyFactory
     * @param request the username, password and Role
     * @return the jwt token and the user's email
     */
    public AuthenticationResponseJwtDTO register(RegisterRequestDTO request) {
        String encodedPsw = passwordEncoder.encode(request.password());
        UserStrategy strategy = userStrategyFactory.findStrategy(request.role());
        User user = strategy.register(request, encodedPsw);
        String jwt = jwtService.generateToken(user);
        return AuthenticationResponseJwtDTOMapper.INSTANCE.convert(jwt, user);
    }

    /**
     * Method that authenticate the user with the given credentials
     * @param request credentials
     * @return the jwt token and the user's email
     */
    public AuthenticationResponseJwtDTO authenticate(AuthenticationRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new EmailNotFoundException("user not found, username " + request.email()));
        String jwt = jwtService.generateToken(user);
        return AuthenticationResponseJwtDTOMapper.INSTANCE.convert(jwt, user);
    }

    /**
     * utility method that put the JWT token in the headers
     * @param jwt token
     * @return the HttpHeaders object to be placed in the ResponseEntity
     */
    public HttpHeaders putJwtInHttpHeaders(String jwt){
        HttpHeaders headers = new HttpHeaders();
        headers.add(JWT, jwt);
        return headers;
    }

    /**
     * Method that reset the password of the given user's email, it does so by generating a random string
     * and setting it as the new passsword, it then email the password to the user's email address
     * @param request user's email
     */
    public void resetPassword(ResetPasswordRequestDTO request) {
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new EmailNotFoundException(request.email()));
        String password = RandomValues.generateRandomString();
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        emailService.sendSimpleEmail(request.email(), password, "Recupero Password");
    }
}
