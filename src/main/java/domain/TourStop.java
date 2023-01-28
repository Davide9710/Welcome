package domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class TourStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Embedded
    private GeographicCoordinates geographicCoordinates;
    private Integer index;
    private String description;
    private Double cost;
    private Long duration;

    @Embedded
    private Transport transport;
    private String otherOptions;

    @OneToMany(fetch = FetchType.EAGER) //TODO it should be eager but paginated
    private List<Image> photos;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Suggestion> suggestions;
}
