import application.WelcomeApplication
import domain.User
import dto.GetAllTagDTO
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
class TagControllerTestIT extends Specification{

    @Autowired
    TestRestTemplate testRestTemplate

    @Autowired
    JwtService jwtService

    def "get All themes test"() {
        given:
        int expectedStatusCode = 200
        int exceptedListSize = 1

        UserDetails userDetails = new User()
        userDetails.setEmail("email1@gmail.com")
        userDetails.setPassword("test")
        String token = jwtService.generateToken(userDetails)

        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION, "Bearer: " + token)

        HttpEntity<String> httpEntity = new HttpEntity<>(headers)

        when:
        def response =
                testRestTemplate.exchange(
                        "/tag",
                        HttpMethod.GET,
                        httpEntity,
                        GetAllTagDTO
                )

        then:
        println response
        response.getStatusCode().value() == expectedStatusCode
        response.getBody().tags().size() == exceptedListSize
        response.getBody().tags().get(0) != null
        response.getBody().tags().get(0).name() == "tag"
    }
}
