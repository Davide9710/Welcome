package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(
        name="PLATFORMUSER",
        uniqueConstraints=
        @UniqueConstraint(name = "UniqueFirstNameAndLastName",columnNames={"firstName", "lastName"})
)
public abstract class PlatformUser extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY) //TODO should be paginated
    private List<Message> messages;

}
