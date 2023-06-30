package dto.response;

import value.Status;

public record TourResponseDTO(String title,
                              Status status,
                              CityResponseDTO city,
                              Double rating) {

}
