package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = {
        "controller",
        "service",
        "mapper",
        "exception",
        "dto",
        "config",
        "specification",
        "exception",
        "aspects.logging",
        "application"
})
@EnableWebMvc
@EnableJpaRepositories(basePackages = {
        "repository"
})
@EntityScan(basePackages = {
        "domain"
})
@EnableAspectJAutoProxy
public class WelcomeApplication {
    public static void main(String[] args) {
        SpringApplication.run(WelcomeApplication.class, args);
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("*").allowedHeaders("*").allowedOrigins("*")
                        .allowedOriginPatterns("/**");
            }
        };
    }
}
