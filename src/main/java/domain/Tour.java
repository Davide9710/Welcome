package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Double approxCost;

    private Long approxDuration;

    private TourStatus tourStatus;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Instant creationTime;

    @UpdateTimestamp
    @Column(nullable = false)
    private Instant lastUpdate;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Tourist> tourists;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Review> reviews;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Report> reports;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Suggestion> suggestions;

    @OneToMany(fetch = FetchType.LAZY)
    private List<TourStop> stops;

    @ManyToOne(fetch = FetchType.EAGER)
    private City city;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tag> tags;

    @ManyToOne
    private Theme theme;

    public enum TourStatus{
        ACTIVE,
        DELETED
    }

    public void setTourStatus(TourStatus tourStatus) {
        this.tourStatus = tourStatus;
    }

    public List<Tag> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", approxCost=" + approxCost +
                ", approxDuration=" + approxDuration +
                ", tourStatus=" + tourStatus +
                ", creationTime=" + creationTime +
                ", lastUpdate=" + lastUpdate +
                ", tourists=" + tourists +
                ", reviews=" + reviews +
                ", reports=" + reports +
                ", suggestions=" + suggestions +
                ", stops=" + stops +
                ", city=" + city +
                ", tags=" + tags +
                ", theme=" + theme +
                '}';
    }

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

    public Double getApproxCost() {
        return approxCost;
    }

    public void setApproxCost(Double approxCost) {
        this.approxCost = approxCost;
    }

    public Long getApproxDuration() {
        return approxDuration;
    }

    public void setApproxDuration(Long approxDuration) {
        this.approxDuration = approxDuration;
    }

    public TourStatus getTourStatus() {
        return tourStatus;
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Instant creationTime) {
        this.creationTime = creationTime;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Tourist> getTourists() {
        return tourists;
    }

    public void setTourists(List<Tourist> tourists) {
        this.tourists = tourists;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public List<Suggestion> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }

    public List<TourStop> getStops() {
        return stops;
    }

    public void setStops(List<TourStop> stops) {
        this.stops = stops;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
}
