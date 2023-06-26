package dto.response;

import dto.TourDTO;

import java.util.List;

public record GetTourByGuideIdResponseDTO(List<TourDTO> tourDTOS) {
}
