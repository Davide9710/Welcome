package service.mailing;

import aspects.logging.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    @Value("${spring.mail.username:null}")
    private String fromEmail;

    private final JavaMailSender mailSender;

    /**
     * Method that send a simple email to the specified email address
     * @param toEmail receiver of the email
     * @param body body of the email
     * @param subject subject of the email
     */
    @Log
    public void sendSimpleEmail(String toEmail, String body, String subject) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
    }
}