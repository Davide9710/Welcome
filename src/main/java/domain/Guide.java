package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static value.Role.GUIDE;
import static value.Role.TOURIST;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@DiscriminatorValue(value = "guide")
public class Guide extends PlatformUser{

    private String organizationName;

    @OneToMany(mappedBy = "guide", fetch = FetchType.LAZY)
    private List<Tour> tours = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    public Guide(String email, String password) {
        super(email, password, GUIDE);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
