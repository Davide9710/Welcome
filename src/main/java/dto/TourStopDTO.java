package dto;

import java.util.List;

public record TourStopDTO(String name,
                          String description,
                          Double cost,
                          GeographicCoordinatesDTO geographicCoordinatesDTO,
                          TransportDTO transportDTO,
                          List<ImageDTO> image) {
}
