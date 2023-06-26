package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import value.Role;

/**
 * entity that contains platform user common data, like the first and last name
 */
@Entity(name = "platform_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(
        name = "platform_user",
        uniqueConstraints =
        @UniqueConstraint(name = "UniqueFirstNameAndLastName", columnNames = {"first_name", "last_name"})
)
@NoArgsConstructor
@Getter
@Setter
public class PlatformUser extends User {

    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "last_name")
    protected String lastName;

    public PlatformUser(String email, String password, Role role) {
        super(email, password, role);
    }
}
