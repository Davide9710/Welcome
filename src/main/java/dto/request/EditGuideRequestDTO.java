package dto.request;

import dto.SelectedCityDTO;

public record EditGuideRequestDTO(String organizationName, SelectedCityDTO city) {
}
