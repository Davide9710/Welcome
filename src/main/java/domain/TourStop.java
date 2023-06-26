package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * entity that contains tour stop data
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class TourStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Embedded
    private GeographicCoordinates coordinates;
    private Integer index;
    private String description;
    private Double cost;
    private String duration;

    @Embedded
    private Transport transport;

    @OneToMany(mappedBy = "tourStop", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Image> images = new ArrayList<>();

    @OneToMany(mappedBy = "tourStop", fetch = FetchType.LAZY)
    private List<Suggestion> suggestions = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Tour tour;

    @Override
    public String toString() {
        return "TourStop{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", coordinates=" + coordinates +
                ", index=" + index +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", duration='" + duration + '\'' +
                ", transport=" + transport +
                '}';
    }
}
