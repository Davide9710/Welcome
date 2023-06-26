package dto.response;

import dto.MessageDTO;

import java.util.List;

public record GetNewMessagesResponseDTO(List<MessageDTO> messages) {
}
