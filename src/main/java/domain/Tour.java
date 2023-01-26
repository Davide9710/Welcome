package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Double aproxCost;

    private Long aproxDuration;

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
    private List<TourStop> tourStops;

    @ManyToOne(fetch = FetchType.EAGER)
    private City city;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tag> tags;
}
