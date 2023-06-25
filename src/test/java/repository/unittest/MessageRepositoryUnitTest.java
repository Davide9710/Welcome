package repository.unittest;

import application.WelcomeApplication;
import domain.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import repository.MessageRepository;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = WelcomeApplication.class)
public class MessageRepositoryUnitTest {

    @Autowired
    MessageRepository messageRepository;

    @Test
    public void findMessagesByCoupleOfUsersAfterEpochTest(){
        //given
        Long mockFirstPlatformUserId = 998L;
        Long mockSecondPlatformUserId = 999L;
        String mockContentFirstMessage = "content first message"; //from the import.sql
        String mockContentSecondMessage = "content second message"; //from the import.sql

        //when
        List<Message> messages = messageRepository.findMessagesByCoupleOfUsersAfterEpoch(Instant.now().minus(10, ChronoUnit.MINUTES),
                mockFirstPlatformUserId,
                mockSecondPlatformUserId);

        //then
        assertNotNull(messages);
        assertEquals(messages.size(), 2);

        //first message
        assertEquals(messages.get(0).getContent(), mockContentFirstMessage);
        assertNotNull(messages.get(0).getSender());
        assertEquals(messages.get(0).getSender().getId(), mockFirstPlatformUserId);
        assertNotNull(messages.get(0).getReceiver());
        assertEquals(messages.get(0).getReceiver().getId(), mockSecondPlatformUserId);

        //second message
        assertEquals(messages.get(1).getContent(), mockContentSecondMessage);
        assertNotNull(messages.get(1).getSender());
        assertEquals(messages.get(1).getSender().getId(), mockSecondPlatformUserId);
        assertNotNull(messages.get(1).getReceiver());
        assertEquals(messages.get(1).getReceiver().getId(), mockFirstPlatformUserId);

    }
}
