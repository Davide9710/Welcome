package service.integrationtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import service.mailing.EmailService;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class EmailServiceTestIT {
    @SpringBootConfiguration
    static class TestConfig {
        @Bean
        JavaMailSender mailSender() {
            return new JavaMailSenderImpl();
        }

        @Bean
        public EmailService beneficiaryContactService() {
            return new EmailService(mailSender());
        }
    }

    @Autowired
    EmailService emailService;

    @Test
    public void sendSimpleEmailTest() {
        assertDoesNotThrow(() ->
                emailService.sendSimpleEmail("davidelaureti54@gmail.com", "test body", "test subject")
        );
    }
}
