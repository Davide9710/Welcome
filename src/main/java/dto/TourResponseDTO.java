package dto;

import value.TourStatus;

public record TourResponseDTO(String title,
                              TourStatus status,
                              CityResponseDTO city,
                              Double rating) {

}
