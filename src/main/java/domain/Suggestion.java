package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * entity that contains suggestion data
 */
@Entity
@Getter
@Setter
public class Suggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tourist author;

    @ManyToOne(fetch = FetchType.LAZY)
    private TourStop tourStop;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tour tour;

    @Override
    public String toString() {
        return "Suggestion{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
