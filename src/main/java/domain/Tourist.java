package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tourist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Tour> tours;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Review> reviews;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Report> reports;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Suggestion> suggestions;
}
