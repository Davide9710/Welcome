package dto;

import lombok.Builder;

public record MessageDTO(String content, long creationTime, PlatformUserDTO sender, PlatformUserDTO receiver) {
    @Builder
    public MessageDTO{

    }
}
