package dto.request;

import jakarta.validation.constraints.Past;

public record GetNewMessagesRequestDTO(@Past long lastMessageEpochInSec,
                                       Long firstPlatformUserId,
                                       Long secondPlatformUserId) {
}
