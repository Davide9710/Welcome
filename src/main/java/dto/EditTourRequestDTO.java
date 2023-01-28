package dto;


import java.util.List;

public record EditTourRequestDTO(String title,
                                 Double aproxCost,
                                 Long aproxDuration,
                                 CityDTO city,
                                 List<TagDTO> tags) {
}
