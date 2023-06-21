package controller.bo;

import dto.UserDTO;

import java.util.List;

public record GetAllUserResponseDTO(List<UserDTO> users) {
}
