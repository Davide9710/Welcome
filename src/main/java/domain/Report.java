package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * entity that contains report data
 */
@Entity
@Getter
@Setter
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reason;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tourist author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_reports")
    private Tour tour;

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", reason='" + reason + '\'' +
                '}';
    }
}
