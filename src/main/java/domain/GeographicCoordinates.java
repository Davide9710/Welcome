package domain;

import lombok.Builder;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Builder
public class GeographicCoordinates {
    private String latitude;
    private String longitude;

    public GeographicCoordinates(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public GeographicCoordinates() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeographicCoordinates that = (GeographicCoordinates) o;
        return Objects.equals(latitude, that.latitude) && Objects.equals(longitude, that.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

    public static GeographicCoordinates of(String latitude, String longitude){
        return GeographicCoordinates.builder()
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }
}
