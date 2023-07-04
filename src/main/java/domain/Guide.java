package domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static value.Role.GUIDE;

/**
 * entity that contains guide specific field
 */
@Entity
@DiscriminatorValue(value = "guide")
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Guide extends PlatformUser{

    private String organizationName;

    @OneToMany(mappedBy = "guide", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Tour> tours = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    public Guide(String email, String password) {
        super(email, password, GUIDE);
    }

    @Override
    public String toString() {
        return "Guide{" +
                "organizationName='" + organizationName + '\'' +
                ", tours=" + tours +
                ", city=" + city +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
