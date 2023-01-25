package domain;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Transport {
    private Double transferCost;
    private Long transferDuration;
    private String transferType;
    private String transferDetails;

    public Transport() {
    }

    public Transport(Double transferCost, Long transferDuration, String transferType, String transferDetails) {
        this.transferCost = transferCost;
        this.transferDuration = transferDuration;
        this.transferType = transferType;
        this.transferDetails = transferDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Objects.equals(transferCost, transport.transferCost) && Objects.equals(transferDuration, transport.transferDuration) && Objects.equals(transferType, transport.transferType) && Objects.equals(transferDetails, transport.transferDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transferCost, transferDuration, transferType, transferDetails);
    }


}
