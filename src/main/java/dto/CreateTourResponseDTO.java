package dto;

import value.TourStatus;

import java.time.Instant;
import java.util.List;

public record CreateTourResponseDTO(String title,
                                    Double approxCost,
                                    String approxDuration,
                                    TourStatus status,
                                    Instant creationTime,
                                    Instant lastUpdate,
                                    CityDTO city,
                                    List<TagResponseDTO> tags,
                                    ThemeDTO theme) {
}
