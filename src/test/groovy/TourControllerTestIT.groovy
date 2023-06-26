import application.WelcomeApplication
import domain.User
import dto.request.SearchTourRequestDTO
import dto.response.SearchTourResponseDTO
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
class TourControllerTestIT extends Specification {

    @Autowired
    TestRestTemplate testRestTemplate

    @Autowired
    JwtService jwtService

    def "search Tour API"() {
        given:
        SearchTourRequestDTO request = new SearchTourRequestDTO(cityId, duration, themeName, tagNames, page, size)

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
                        "/tour/search",
                        HttpMethod.POST,
                        httpEntity,
                        SearchTourResponseDTO)

        then:
        println response
        response.getStatusCode().value() == expectedStatusCode
        response.getBody().tours() != null
        response.getBody().tours().size() == expectedListSize

        where:
        cityId | duration | themeName    | tagNames | page | size || expectedStatusCode | expectedListSize
        1      | 30       | "panoramico" | null     | 0    | 10   || 200                | 0 //duration too little
        2      | 120      | "panoramico" | null     | 0    | 10   || 200                | 0 //wrong city
        1      | 120      | "avventura"  | null     | 0    | 10   || 200                | 0 //different theme

    }
}
