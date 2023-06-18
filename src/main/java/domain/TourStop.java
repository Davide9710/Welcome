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

import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GeographicCoordinates getGeographicCoordinates() {
        return coordinates;
    }

    public void setGeographicCoordinates(GeographicCoordinates geographicCoordinates) {
        this.coordinates = geographicCoordinates;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Suggestion> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }

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
