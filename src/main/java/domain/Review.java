package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * entity that contains review data
 */
@Entity
@Setter
@Getter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(updatable = false, nullable = false, name = "creation_timestamp")
    private Instant creationTimestamp;

    @Column(name = "title")
    private String title;

    @Min(0)
    @Max(5)
    @Column(name = "stars")
    private Double stars;

    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "review", fetch = FetchType.LAZY)
    private List<Image> images = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Tourist author;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tour tour;

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", creationTimestamp=" + creationTimestamp +
                ", title='" + title + '\'' +
                ", stars=" + stars +
                ", content='" + content + '\'' +
                '}';
    }
}
