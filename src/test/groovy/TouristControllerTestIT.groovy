import application.WelcomeApplication
import domain.User
import dto.MarkAsCompleteRequestDTO
import dto.MarkedToursResponseDTO
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
class TouristControllerTestIT extends Specification {

    @Autowired
    TestRestTemplate testRestTemplate

    @Autowired
    JwtService jwtService

    def "get all marked tour test"(){
        given:
        Long touristId = 998L
        int expectedStatusCode = 200
        int tourSize = 1

        UserDetails userDetails = new User()
        userDetails.setEmail("email1@gmail.com")
        userDetails.setPassword("test")
        String token = jwtService.generateToken(userDetails)

        HttpHeaders headers = new HttpHeaders()
        headers.add(AUTHORIZATION, "Bearer: " + token)

        HttpEntity<String> httpEntity = new HttpEntity<>(headers)

        when:
        def response =
                testRestTemplate.exchange(
                        "/tourist/" + touristId + "/marked-tours",
                        HttpMethod.GET,
                        httpEntity,
                        MarkedToursResponseDTO)

        then:
        println response
        response.getStatusCode().value() == expectedStatusCode
        response.getBody().tours().size() == tourSize
    }

    def "mark tour as completed by a tourist"() {
        given:
        Long touristId = 998L
        Long tourId = 999L
        int expectedStatusCode = 200

        when:
        MarkAsCompleteRequestDTO request = new MarkAsCompleteRequestDTO(touristId, tourId)

        UserDetails userDetails = new User()
        userDetails.setEmail("email1@gmail.com")
        userDetails.setPassword("test")
        String token = jwtService.generateToken(userDetails)

        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION, "Bearer: " + token)

        HttpEntity<String> httpEntity = new HttpEntity<>(request, headers)

        def response =
                testRestTemplate.exchange(
                        "/tourist/mark-as-completed",
                        HttpMethod.POST,
                        httpEntity,
                        Object)

        then:
        println response
        response.getStatusCode().value() == expectedStatusCode
    }
}
