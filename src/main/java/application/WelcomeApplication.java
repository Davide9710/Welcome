package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class WelcomeApplication {
    public static void main(String[] args) {
        SpringApplication.run(WelcomeApplication.class, args);
    }
}
