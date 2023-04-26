package dto;

import domain.Tour;

import java.time.Instant;
import java.util.List;

public record CreateTourResponseDTO(String title,
                                    Double approxCost,
                                    String approxDuration,
                                    Tour.TourStatus status,
                                    Instant creationTime,
                                    Instant lastUpdate,
                                    CityDTO city,
                                    List<TagResponseDTO> tags,
                                    ThemeDTO theme) {
}
