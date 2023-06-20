package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.NoArgsConstructor;
import value.Role;

import java.util.List;

@Entity(name="platform_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type", discriminatorType = DiscriminatorType.STRING)
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(
        name="platform_user",
        uniqueConstraints=
        @UniqueConstraint(name = "UniqueFirstNameAndLastName", columnNames={"first_name", "last_name"})
)
@NoArgsConstructor
public class PlatformUser extends User{

    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "last_name")
    protected String lastName;

    @OneToMany(mappedBy = "receiver", fetch = FetchType.LAZY)
    protected List<Message> messagesReceived;

    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY)
    protected List<Message> messagesSend;

    public PlatformUser(String username, String password, Role role) {
        super(username, password, role);
    }

    public Long getId() {
        return super.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
