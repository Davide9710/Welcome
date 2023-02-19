package domain;

import lombok.Builder;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Builder
public class GeographicCoordinates {
    private Double latitude;
    private Double longitude;

    public GeographicCoordinates() {
    }

    public GeographicCoordinates(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
