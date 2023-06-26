package dto;

public record SendMessageRequestDTO(Long senderId,
                                    Long receiverId,
                                    long creationEpochInSec,
                                    String content) {
}

