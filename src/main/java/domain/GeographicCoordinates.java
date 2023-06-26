package domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * entity that contains geographic coordinates data
 */
@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeographicCoordinates {
    private Double latitude;
    private Double longitude;
}
