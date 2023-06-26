package service;

import domain.Message;
import domain.PlatformUser;
import dto.MessageDTO;
import dto.request.SendMessageRequestDTO;
import lombok.RequiredArgsConstructor;
import mapper.platformuser.PlatformUserDTOMapper;
import org.springframework.stereotype.Service;
import repository.MessageRepository;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final PlatformUserService platformUserService;

    /**
     * Method that get new messages from the specified epoch for the specified couple of platform user
     * It first gets the messages from Platform User A to B, then the opposite, then it joins the lists
     * @param epoch epoch in seconds form 1970
     * @param firstId id of the first user
     * @param secondId id of the second user
     * @return the messages list
     */
    public List<MessageDTO> getNewMessages(Long epoch, Long firstId, Long secondId) {
        List<Message> messages = messageRepository.findMessagesByCoupleOfUsersAfterEpoch(
                Instant.ofEpochSecond(epoch),
                firstId,
                secondId);
        return getMessagesDTOFromEntity(messages);
    }

    private List<MessageDTO> getMessagesDTOFromEntity(List<Message> messages) {
        return messages.stream().map(
                message -> new MessageDTO(message.getContent(),
                        message.getCreationTime().getEpochSecond(),
                        PlatformUserDTOMapper.INSTANCE.convert(message.getSender()),
                        PlatformUserDTOMapper.INSTANCE.convert(message.getReceiver()))
        ).toList();
    }

    public Message getMessageFromSendMessageDTO(SendMessageRequestDTO sendMessageRequestDTO) {
        PlatformUser sender = platformUserService.getPlatformUserById(sendMessageRequestDTO.senderId());
        PlatformUser receiver = platformUserService.getPlatformUserById(sendMessageRequestDTO.receiverId());
        return Message.builder()
                .sender(sender)
                .receiver(receiver)
                .content(sendMessageRequestDTO.content())
                .creationTime(Instant.ofEpochSecond(sendMessageRequestDTO.creationEpochInSec()))
                .build();
    }

    public void sendMessage(SendMessageRequestDTO sendMessageRequestDTO) {
        messageRepository.save(getMessageFromSendMessageDTO(sendMessageRequestDTO));
    }
}
