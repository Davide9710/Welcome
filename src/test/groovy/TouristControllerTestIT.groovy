import application.WelcomeApplication
import dto.MarkAsCompleteRequestDTO
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
class TouristControllerTestIT extends Specification {

    @Autowired
    TestRestTemplate testRestTemplate

    //TODO controlla se stai fetchando tutti i tour
    def "mark tour as completed by a tourist"(){
        given:
        Long touristId = 1L
        Long tourId = 1L
        int expectedStatusCode = 200

        when:
        MarkAsCompleteRequestDTO request = new MarkAsCompleteRequestDTO(touristId, tourId)

        HttpEntity<String> httpEntity = new HttpEntity<>(request)


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
