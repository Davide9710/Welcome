import application.WelcomeApplication
import domain.User
import dto.CreateReviewRequestDTO
import dto.CreateReviewResponseDTO
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

import static value.Constants.AUTHORIZATION

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = WelcomeApplication.class)
@TestPropertySource(locations = ["classpath:application-test.yml"],
        properties = ["spring.sql.init.data-locations=classpath:data-test.sql"])
@ActiveProfiles("test")
class ReviewControllerTestIT extends Specification {

    @Autowired
    TestRestTemplate testRestTemplate

    @Autowired
    JwtService jwtService

    def "create Review test"() {
        given:
        CreateReviewRequestDTO request = new CreateReviewRequestDTO(title, stars, content, authorId, tourId)

        UserDetails userDetails = new User()
        userDetails.setEmail("email1@gmail.com")
        userDetails.setPassword("test")
        String token = jwtService.generateToken(userDetails)

        HttpHeaders headers = new HttpHeaders()
        headers.add(AUTHORIZATION, "Bearer: " + token)

        HttpEntity<String> httpEntity = new HttpEntity<>(request, headers)

        when:
        def response =
                testRestTemplate.exchange(
                        "/review/create",
                        HttpMethod.POST,
                        httpEntity,
                        CreateReviewResponseDTO)

        then:
        println response
        response.getStatusCode().value() == expectedStatusCode
        if(response.getStatusCode().value() == 200) {
            response.getBody().review() != null
            response.getBody().review().title() == title
            response.getBody().review().stars() == stars
            response.getBody().review().content() == content
        }

        where:
        title      | stars | content             | authorId | tourId || expectedStatusCode
        "Orribile" | 1     | "Pessima scelta..." | 998      | 1      || 200
        "Orribile" | null  | "Pessima scelta..." | null     | null   || 400 //Bad request because of validation
    }
}
