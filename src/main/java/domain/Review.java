package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.checkerframework.common.value.qual.IntVal;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Instant;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Instant creationTime;

    private String title;

    @Min(0)
    @Max(5)
    private Integer stars; /*from 0 to 5 constraint*/

    private String content;
}
