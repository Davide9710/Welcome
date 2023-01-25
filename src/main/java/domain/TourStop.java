package domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class TourStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Double latitude;
    private Double longitude;
    private Integer index;
    private String description;
    private Double cost;
    private Long duration;
    private Double transferCost;
    private Long transferDuration;
    private String transferType;
    private String transferDetails;
    private String otherOptions;

    private Image[] photos;
}
