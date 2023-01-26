package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToMany(fetch = FetchType.EAGER)
    @Size(min = 2, max = 2)
    private List<PlatformUser> users;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Instant creationTime;
}
