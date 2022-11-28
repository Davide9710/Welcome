package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Double aproxCost;

    private Long aproxDuration;

    private Long cityId;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Instant creationTime;

    @UpdateTimestamp
    @Column(nullable = false)
    private Instant lastUpdate;
}
