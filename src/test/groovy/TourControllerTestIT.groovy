import application.WelcomeApplication
import dto.SearchTourRequestDTO
import dto.SearchTourResponseDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = WelcomeApplication)
@TestPropertySource(locations = ["classpath:application-test.properties"]
/*, properties = "spring.sql.init.data-locations=classpath:confirm.sql"*/
)
@ActiveProfiles("local")
class TourControllerTestIT extends Specification {

    @Autowired
    TestRestTemplate testRestTemplate

    def "search Tour API"(){
        given:

        when:
        HttpHeaders headers = new HttpHeaders()
        SearchTourRequestDTO request = new SearchTourRequestDTO(cityId, duration, themeName, tagNames)

        HttpEntity<String> httpEntity = new HttpEntity<>(request, headers)


        def response =
                testRestTemplate.exchange(
                        "/tour/search",
                        HttpMethod.POST,
                        httpEntity,
                        SearchTourResponseDTO)

        then:

        where:
        cityId | duration | themeName | tagNames || expectedStatusCode


    }
}
