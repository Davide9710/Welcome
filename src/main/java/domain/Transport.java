package domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

/**
 * Embeddable entity that contains tour stop data
 */
@Embeddable
@Getter
@Setter
public class Transport {
    private Double transportCost;
    private String transportDuration;
    private String transportType;
    private String transportDetails;
    private String transportOtherOptions;

    public Transport() {
    }

    public Transport(Double transportCost, String transportDuration, String transportType, String transportDetails, String transportOtherOptions) {
        this.transportCost = transportCost;
        this.transportDuration = transportDuration;
        this.transportType = transportType;
        this.transportDetails = transportDetails;
        this.transportOtherOptions = transportOtherOptions;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "transferCost=" + transportCost +
                ", transferDuration='" + transportDuration + '\'' +
                ", transferType='" + transportType + '\'' +
                ", transferDetails='" + transportDetails + '\'' +
                ", otherOptions='" + transportOtherOptions + '\'' +
                '}';
    }
}
