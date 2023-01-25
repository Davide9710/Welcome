package domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dto.GeographicCoordinatesDTO;

import javax.persistence.Embedded;
import javax.persistence.Entity;
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

    @OneToMany()
    private List<Image> photos;
}
