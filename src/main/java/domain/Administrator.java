package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity(name = "administrator")
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class Administrator extends User {
}
