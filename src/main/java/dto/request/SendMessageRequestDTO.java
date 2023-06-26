package dto.request;

public record SendMessageRequestDTO(Long senderId,
                                    Long receiverId,
                                    long creationEpochInSec,
                                    String content) {
}

