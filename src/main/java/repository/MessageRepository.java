package repository;

import domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;

/**
 * Message repository that use JPA to access db data
 */
public interface MessageRepository extends JpaRepository<Message, Long> {
    /**
     * Method that return new messages, sent after the specified instant, the conversion is automatically done by Spring
     * Here a native query is used to leverage the UNION query from SQL, more efficient than union a
     * @param lastMessageInstant instant of last message
     * @param firstPlatformUserId first platform user id
     * @param secondPlatformUserId second platform user id
     * @return the list of new messages
     */
    @Query(value = "SELECT * FROM Message m WHERE m.sender = :firstId AND m.receiver = :secondId AND m.creation_time > :instant " +
                    "UNION " +
                    "SELECT * FROM Message m WHERE m.sender = :secondId AND m.receiver = :firstId AND m.creation_time > :instant ",
            nativeQuery = true)
    List<Message> findMessagesByCoupleOfUsersAfterEpoch(@Param("instant") Instant lastMessageInstant,
                                                        @Param("firstId") Long firstPlatformUserId,
                                                        @Param("secondId") Long secondPlatformUserId);

}
