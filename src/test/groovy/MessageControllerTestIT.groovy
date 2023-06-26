import application.WelcomeApplication
import domain.User
import dto.response.GetNewMessagesResponseDTO
import dto.request.SendMessageRequestDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource
import service.auth.JwtService
import spock.lang.Specification

import java.time.Instant
import java.time.temporal.ChronoUnit

import static value.Constants.AUTHORIZATION

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = WelcomeApplication.class)
@TestPropertySource(locations = ["classpath:application-test.yml"],
        properties = ["spring.sql.init.data-locations=classpath:data-test.sql"])
@ActiveProfiles("test")
class MessageControllerTestIT extends Specification {

    @Autowired
    TestRestTemplate testRestTemplate

    @Autowired
    JwtService jwtService

    def "get new messages"() {
        given:
        UserDetails userDetails = new User()
        userDetails.setEmail("email1@gmail.com")
        userDetails.setPassword("test")
        String token = jwtService.generateToken(userDetails)

        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION, "Bearer: " + token)

        def epochSecond = Instant.now().minus(10, ChronoUnit.MINUTES).getEpochSecond()

        HttpEntity<String> httpEntity = new HttpEntity<>(headers)

        when:
        def response =
                testRestTemplate.exchange(
                        "/message/new?epoch=" + epochSecond + "&firstId=" + firstId + "&secondId=" + secondId,
                        HttpMethod.GET,
                        httpEntity,
                        GetNewMessagesResponseDTO)

        then:
        println response
        response.getStatusCode().value() == expectedStatusCode

        where:
        firstId | secondId || expectedStatusCode
        998     | 999      || 200
    }

    def "send messages"() {
        given:
        UserDetails userDetails = new User()
        userDetails.setEmail("email1@gmail.com")
        userDetails.setPassword("test")
        String token = jwtService.generateToken(userDetails)

        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION, "Bearer: " + token)

        SendMessageRequestDTO request = new SendMessageRequestDTO(
                firstId,
                secondId,
                Instant.now().getEpochSecond(),
                "content"
        )
        HttpEntity<String> httpEntity = new HttpEntity<>(request, headers)

        when:
        def response =
                testRestTemplate.exchange(
                        "/message/send",
                        HttpMethod.POST,
                        httpEntity,
                        Object)

        then:
        println response
        response.getStatusCode().value() == expectedStatusCode

        where:
        firstId | secondId || expectedStatusCode
        998     | 999      || 200
    }
}
