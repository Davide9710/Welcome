package dto;

import java.util.List;

public record SearchTourRequestDTO(Long cityId,
                                   Integer maxDuration,
                                   String themeName,
                                   List<String> tagNames,
                                   int pageNumber,
                                   int pageSize) {
}
