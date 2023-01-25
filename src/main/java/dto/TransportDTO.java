package dto;

public record TransportDTO(Double transferCost,
                           Long transferDuration,
                           String transferType,
                           String transferDetails) {
}
