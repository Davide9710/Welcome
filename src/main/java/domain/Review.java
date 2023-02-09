package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Instant;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Instant creationTimestamp;

    private String title;

    @Min(0)
    @Max(5)
    private Integer stars; /*from 0 to 5 constraint*/

    private String content;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Image> images;

    @ManyToOne(fetch = FetchType.EAGER)
    private Tourist author;
}
