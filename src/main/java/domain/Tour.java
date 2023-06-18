package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import value.TourStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
//@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "UPDATE tour SET status = 'DELETED' WHERE id = ?")
@Where(clause = "status <> 'DELETED'")
public class Tour /*extends SoftDeletable*/{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "approx_cost")
    private Double approxCost;

    @Column(name = "approx_duration")
    private Integer approxDuration;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
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

    @Formula("SELECT AVG(r.stars) FROM Review r WHERE r.tour_id = id")
    private Double rating;

    @Column(name = "number_of_reviews")
    private Long numberOfReviews;

    public void incrementNumberOfReviews() {
        this.numberOfReviews++;
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
