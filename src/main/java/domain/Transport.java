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

    public Double getTransferCost() {
        return transferCost;
    }

    public void setTransferCost(Double transferCost) {
        this.transferCost = transferCost;
    }

    public Long getTransferDuration() {
        return transferDuration;
    }

    public void setTransferDuration(Long transferDuration) {
        this.transferDuration = transferDuration;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public String getTransferDetails() {
        return transferDetails;
    }

    public void setTransferDetails(String transferDetails) {
        this.transferDetails = transferDetails;
    }

    public String getOtherOptions() {
        return otherOptions;
    }

    public void setOtherOptions(String otherOptions) {
        this.otherOptions = otherOptions;
    }
}
