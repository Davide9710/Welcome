package service.unittest.auth;

import domain.User;
import dto.request.ResetPasswordRequestDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import repository.UserRepository;
import service.auth.AuthenticationService;
import service.auth.JwtService;
import service.mailing.EmailService;
import service.userstrategy.UserStrategyFactory;
import utils.RandomValues;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
public class AuthenticationServiceUnitTest {
    @SpringBootConfiguration
    static class TestConfig {
        @Autowired
        UserRepository userRepository;
        @Autowired
        PasswordEncoder passwordEncoder;
        @Autowired
        JwtService jwtService;
        @Autowired
        AuthenticationManager authenticationManager;
        @Autowired
        UserStrategyFactory userStrategyFactory;
        @Autowired
        EmailService emailService;


        @Bean
        public AuthenticationService authenticationService() {
            return new AuthenticationService(userRepository,
                    passwordEncoder,
                    jwtService,
                    authenticationManager,
                    userStrategyFactory,
                    emailService);
        }
    }

    @Autowired
    AuthenticationService authenticationService;

    @MockBean
    UserRepository userRepository;

    @MockBean
    PasswordEncoder passwordEncoder;

    @MockBean
    JwtService jwtService;

    @MockBean
    AuthenticationManager authenticationManager;

    @MockBean
    UserStrategyFactory userStrategyFactory;

    @MockBean
    EmailService emailService;

    @MockBean
    RandomValues randomValues;

    @Test
    public void sendSimpleEmailTest() {
        String email = "mock";
        User userMock = new User("email", "password");
        String mockNewPassword = "alpha12345";
        String mockNewPasswordEncoded = "alpha12345Encoded";
        ResetPasswordRequestDTO request = new ResetPasswordRequestDTO(email);
        Mockito.when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(userMock));
        Mockito.mockStatic(RandomValues.class).when(RandomValues::generateRandomString).thenReturn(mockNewPassword);
        Mockito.when(passwordEncoder.encode(anyString())).thenReturn(mockNewPasswordEncoded);
        Mockito.when(userRepository.save(any())).thenReturn(null);
        Mockito.doNothing().when(emailService).sendSimpleEmail(anyString(), anyString(), anyString());
        assertDoesNotThrow(() ->
                authenticationService.resetPassword(request)
        );
    }
}
