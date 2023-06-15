package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Administrator extends User {

    public Administrator() {
        super();
    }
}
