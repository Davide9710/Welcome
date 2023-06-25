package dto;

import java.util.List;

public record GetNewMessagesResponseDTO(List<MessageDTO> messages) {
}
