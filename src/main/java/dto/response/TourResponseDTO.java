package dto.response;

import dto.response.CityResponseDTO;
import value.Status;

public record TourResponseDTO(String title,
                              Status status,
                              CityResponseDTO city,
                              Double rating) {

}
