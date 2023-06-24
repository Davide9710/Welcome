package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static value.Role.GUIDE;

/**
 * entity that contains guide specific field
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@DiscriminatorValue(value = "guide")
@NoArgsConstructor
public class Guide extends PlatformUser{

    private String organizationName;

    @OneToMany(mappedBy = "guide", fetch = FetchType.LAZY)
    private List<Tour> tours = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    public Guide(String email, String password) {
        super(email, password, GUIDE);
    }
}
