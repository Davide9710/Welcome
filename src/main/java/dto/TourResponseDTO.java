package dto;

import domain.Tour;

public record TourResponseDTO(String title,
                              Tour.TourStatus status,
                              CityResponseDTO city,
                              Double rating) {

}
