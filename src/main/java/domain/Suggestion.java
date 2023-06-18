package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Suggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tourist author;

    @ManyToOne(fetch = FetchType.LAZY)
    private TourStop tourStop;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tour tour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tourist getAuthor() {
        return author;
    }

    public void setAuthor(Tourist author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Suggestion{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
