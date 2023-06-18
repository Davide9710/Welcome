package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Builder;
import org.springframework.security.core.userdetails.UserDetails;
import value.Role;

@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public abstract class User implements UserDetails { //TODO Remove this comments
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String email;

    protected String password;
    protected Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
