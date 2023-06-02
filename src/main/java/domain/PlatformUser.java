package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;

@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(
        name="PLATFORMUSER",
        uniqueConstraints=
        @UniqueConstraint(name = "UniqueFirstNameAndLastName",columnNames={"first_name", "last_name"})
)
public abstract class PlatformUser extends User{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "receiver", fetch = FetchType.LAZY)
    private List<Message> messagesReceived;

    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY)
    private List<Message> messagesSend;

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
