package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Entity(name = "administrator")
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class Administrator extends User {
}
