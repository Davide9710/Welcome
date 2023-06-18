import application.WelcomeApplication
import dto.GetAllCityResponseDTO
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
class CityControllerTestIT extends Specification{
    @Autowired
    TestRestTemplate testRestTemplate

    def "get all cities test"() {
        given:
        int expectedStatusCode = 200
        int exceptedListSize = 3

        when:
        HttpEntity<String> httpEntity = new HttpEntity<>()

        def response =
                testRestTemplate.exchange(
                        "/city",
                        HttpMethod.GET,
                        httpEntity,
                        GetAllCityResponseDTO)
        then:
        println response
        response.getStatusCode().value() == expectedStatusCode
        response.getBody().cities().size() == exceptedListSize
    }
}
