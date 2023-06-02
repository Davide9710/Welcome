import application.WelcomeApplication
import dto.CreateReviewRequestDTO
import dto.CreateReviewResponseDTO
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
@Sql("/review.sql")
class ReviewControllerTestIT extends Specification {

    @Autowired
    TestRestTemplate testRestTemplate;

    def "create Review test"() {
        given:

        when:
        CreateReviewRequestDTO request = new CreateReviewRequestDTO(title, stars, content, authorId, tourId)

        HttpEntity<String> httpEntity = new HttpEntity<>(request)


        def response =
                testRestTemplate.exchange(
                        "/review/create",
                        HttpMethod.POST,
                        httpEntity,
                        CreateReviewResponseDTO)

        then:
        println response
        response.getStatusCode().value() == expectedStatusCode
        response.getBody().review() != null
        response.getBody().review().title() == title
        response.getBody().review().stars() == stars
        response.getBody().review().content() == content

        where:
        title      | stars | content             | authorId | tourId || expectedStatusCode
        "Orribile" | 1     | "Pessima scelta..." | 1        | 1      || 200
    }
}
