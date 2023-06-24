package domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static value.Role.TOURIST;

/**
 * entity that contains tourist specific field
 */
@Entity(name = "tourist")
@DiscriminatorValue(value = "tourist")
@NoArgsConstructor
@Setter
@Getter
public class Tourist extends PlatformUser{

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "tourist_tour",
        joinColumns = @JoinColumn(name = "tourist_id"),
        inverseJoinColumns = @JoinColumn(name = "tour_id")
    )
    private List<Tour> tours = new ArrayList<>();

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Report> reports = new ArrayList<>();

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Suggestion> suggestions = new ArrayList<>();

    public Tourist(String email, String password) {
        super(email, password, TOURIST);
    }


    public void addTour(Tour tour){
        this.tours.add(tour);
        tour.getTourists().add(this);
    }

    public void removeTour(Tour tour){
        this.tours.remove(tour);
        tour.getTourists().remove(this);
    }

    @Override
    public String toString() {
        return "Tourist{" +
                "id=" + id +
                '}';
    }
}
