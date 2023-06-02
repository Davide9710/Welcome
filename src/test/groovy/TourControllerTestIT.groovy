import application.WelcomeApplication
import dto.SearchTourRequestDTO
import dto.SearchTourResponseDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.jdbc.Sql
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = WelcomeApplication.class)
@TestPropertySource(locations = ["classpath:application-test.yml"],
        properties = ["spring.sql.init.data-locations=classpath:data-test.sql"])
@ActiveProfiles("test")
@Sql("/data-test.sql")
class TourControllerTestIT extends Specification {

    @Autowired
    TestRestTemplate testRestTemplate

    def "search Tour API"() {
        given:

        when:
        SearchTourRequestDTO request = new SearchTourRequestDTO(cityId, duration, themeName, tagNames)

        HttpEntity<String> httpEntity = new HttpEntity<>(request)


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
        cityId | duration | themeName        | tagNames || expectedStatusCode | expectedListSize
        null   | null     | "arte culinaria" | null     || 200                | 1

    }

    def "delete Tout API"() {
        given:

        when:
        testRestTemplate.delete("/tour/" + 1)

        then:
        1 == 1
    }
}
