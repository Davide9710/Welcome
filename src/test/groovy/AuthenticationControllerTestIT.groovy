import application.WelcomeApplication
import dto.AuthenticationRequestDTO
import dto.RegisterRequestDTO
import dto.ResetPasswordRequestDTO
import org.aspectj.lang.annotation.Before
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource
import service.mailing.EmailService
import spock.lang.Specification
import value.Role

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = WelcomeApplication.class)
@TestPropertySource(locations = ["classpath:application-test.yml"],
        properties = ["spring.sql.init.data-locations=classpath:data-test.sql"])
@ActiveProfiles("test")
class AuthenticationControllerTestIT extends Specification {
    @Autowired
    TestRestTemplate testRestTemplate

    @MockBean
    EmailService emailService

    def "test login"() {
        given:
        AuthenticationRequestDTO request = new AuthenticationRequestDTO(email, "test")
        HttpEntity<String> httpEntity = new HttpEntity<>(request)

        when:
        def response =
                testRestTemplate.exchange(
                        "/auth/authenticate",
                        HttpMethod.POST,
                        httpEntity,
                        Object)


        then:
        println response
        response.getStatusCode().value() == expectedStatusCode

        where:
        email                  || expectedStatusCode
        "email1@gmail.com"     || 200
        "wrongemail@gmail.com" || 404
        "wrong email"          || 400
    }

    def "test register"() {
        given:
        RegisterRequestDTO request = new RegisterRequestDTO(email, "test", Role.TOURIST)
        HttpEntity<String> httpEntity = new HttpEntity<>(request)

        when:
        def response =
                testRestTemplate.exchange(
                        "/auth/register",
                        HttpMethod.POST,
                        httpEntity,
                        Object)


        then:
        println response
        response.getStatusCode().value() == expectedStatusCode

        where:
        email               || expectedStatusCode
        "newmail@gmail.com" || 200
        "email1@gmail.com"  || 409 //existing email -> Conflict
        "wrong email"       || 400
    }

    def "reset password"() {
        given:
        ResetPasswordRequestDTO request = new ResetPasswordRequestDTO(email)
        HttpEntity<String> httpEntity = new HttpEntity<>(request)
        emailService.sendSimpleEmail(_, _, _) >> null

        when:
        def response =
                testRestTemplate.exchange(
                        "/auth/reset-psw",
                        HttpMethod.POST,
                        httpEntity,
                        Object)


        then:
        println response
        response.getStatusCode().value() == expectedStatusCode

        where:
        email                        || expectedStatusCode
        "email1@gmail.com"           || 200
        "notexistingemail@gmail.com" || 404
        "wrong email"                || 400
    }
}
