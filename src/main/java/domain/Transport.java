package domain;

import javax.persistence.Embeddable;

@Embeddable
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

    public Double getTransportCost() {
        return transportCost;
    }

    public void setTransportCost(Double transferCost) {
        this.transportCost = transferCost;
    }

    public String getTransportDuration() {
        return transportDuration;
    }

    public void setTransportDuration(String transferDuration) {
        this.transportDuration = transferDuration;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transferType) {
        this.transportType = transferType;
    }

    public String getTransportDetails() {
        return transportDetails;
    }

    public void setTransportDetails(String transferDetails) {
        this.transportDetails = transferDetails;
    }

    public String getTransportOtherOptions() {
        return transportOtherOptions;
    }

    public void setTransportOtherOptions(String otherOptions) {
        this.transportOtherOptions = otherOptions;
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
