package dto;

import domain.Tour;

public record TourResponseDTO(String title,
                              Tour.TourStatus tourStatus,
                              CityResponseDTO city) {

}
