package domain;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Transport {
    private Double transferCost;
    private Long transferDuration;
    private String transferType;
    private String transferDetails;
    private String otherOptions;

    public Transport() {
    }

    public Transport(Double transferCost, Long transferDuration, String transferType, String transferDetails, String otherOptions) {
        this.transferCost = transferCost;
        this.transferDuration = transferDuration;
        this.transferType = transferType;
        this.transferDetails = transferDetails;
        this.otherOptions = otherOptions;
    }
}
