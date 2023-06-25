import application.WelcomeApplication
import dto.GetAllThemeResponseDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = WelcomeApplication.class)
@TestPropertySource(locations = ["classpath:application-test.yml"],
        properties = ["spring.sql.init.data-locations=classpath:data-test.sql"])
@ActiveProfiles("test")
class ThemeControllerTestIT extends Specification{

    @Autowired
    TestRestTemplate testRestTemplate

    def "get All themes test"() {
        given:
        int expectedStatusCode = 200
        int exceptedListSize = 1

        when:
        HttpEntity<String> httpEntity = new HttpEntity<>()


        def response =
                testRestTemplate.exchange(
                        "/theme",
                        HttpMethod.GET,
                        httpEntity,
                        GetAllThemeResponseDTO
                )

        then:
        println response
        response.getStatusCode().value() == expectedStatusCode
        response.getBody().themes().size() == exceptedListSize
        response.getBody().themes().get(0) != null
        response.getBody().themes().get(0).name() == "arte culinaria"
    }
}
