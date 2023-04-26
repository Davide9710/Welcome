package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Double approxCost;

    private String approxDuration;

    private TourStatus status = TourStatus.ACTIVE;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Instant creationTime;

    @UpdateTimestamp
    @Column(nullable = false)
    private Instant lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Guide guide;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tours")
    private Set<Tourist> tourists = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "tour")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "tour")
    private List<Report> reports = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "tour")
    private List<Suggestion> suggestions = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "tour")
    private List<TourStop> TourStops = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "tour_tag",
        joinColumns = @JoinColumn(name = "tour_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Theme theme;

    public enum TourStatus{
        ACTIVE,
        DELETED
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", approxCost=" + approxCost +
                ", approxDuration=" + approxDuration +
                ", tourStatus=" + status +
                ", creationTime=" + creationTime +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
        theme.getTours().add(this);
    }

    public void addTag(Tag tag){
        this.tags.add(tag);
        tag.getTours().add(this);
    }

    public void removeTag(Tag tag){
        this.tags.remove(tag);
        tag.getTours().remove(this);
    }

    public void addTourist(Tourist tourist) {
        tourists.remove(tourist);
    }

    public void removeTourist(Tourist tourist) {
        tourists.remove(tourist);
    }

}
