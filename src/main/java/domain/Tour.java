package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
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
