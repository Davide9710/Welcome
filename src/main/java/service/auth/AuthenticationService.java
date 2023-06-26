package service.auth;

import domain.User;
import dto.request.AuthenticationRequestDTO;
import dto.response.AuthenticationResponseJwtDTO;
import dto.RegisterRequestDTO;
import dto.request.ResetPasswordRequestDTO;
import exception.EmailAlreadyUsedException;
import exception.notfound.EmailNotFoundException;
import lombok.RequiredArgsConstructor;
import mapper.jwt.AuthenticationResponseJwtDTOMapper;
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

import static value.Constants.AUTHORIZATION;
import static value.Constants.BEARER;

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
        if(userRepository.existsByEmail(request.email())) throw new EmailAlreadyUsedException(request.email());
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
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new EmailNotFoundException("user not found, username " + request.email()));
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
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
        headers.add(AUTHORIZATION, BEARER + jwt);
        return headers;
    }

    /**
     * Method that reset the password of the given user's email, it does so by generating a random string
     * and setting it as the new password, it then email the password to the user's email address
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
