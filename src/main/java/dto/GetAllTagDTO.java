package dto;

import dto.response.TagResponseDTO;

import java.util.List;

public record GetAllTagDTO(List<TagResponseDTO> tags){
}
