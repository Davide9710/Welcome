package dto.response;

import dto.CityDTO;
import dto.ThemeDTO;
import value.Status;

import java.time.Instant;
import java.util.List;

public record CreateTourResponseDTO(String title,
                                    Double approxCost,
                                    String approxDuration,
                                    Status status,
                                    Instant creationTime,
                                    Instant lastUpdate,
                                    CityDTO city,
                                    List<TagResponseDTO> tags,
                                    ThemeDTO theme) {
}
