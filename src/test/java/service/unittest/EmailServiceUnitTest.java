package service.unittest;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import service.mailing.EmailService;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class EmailServiceUnitTest {
    @SpringBootConfiguration
    static class TestConfig {
        @Bean
        JavaMailSender mailSender() {
            return new JavaMailSenderImpl();
        }

        @Bean
        public EmailService emailService() {
            return new EmailService(mailSender());
        }
    }

    @Autowired
    EmailService emailService;

    @MockBean
    JavaMailSender javaMailSender;

    @Test
    public void sendSimpleEmailTest() {
        Mockito.doNothing().when(javaMailSender).send((SimpleMailMessage) any());
        assertDoesNotThrow(() ->
                emailService.sendSimpleEmail("davidelaureti54@gmail.com", "test body", "test subject")
        );
    }
}
