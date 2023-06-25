package service;

import domain.Message;
import domain.PlatformUser;
import dto.GetNewMessagesRequestDTO;
import dto.MessageDTO;
import dto.SendMessageRequestDTO;
import lombok.RequiredArgsConstructor;
import mapper.PlatformUserDTOMapper;
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
     *
     * @param getNewMessagesRequestDTO epoch in seconds, and two users id
     * @return the messages list
     */
    public List<MessageDTO> getNewMessages(GetNewMessagesRequestDTO getNewMessagesRequestDTO) {
        List<Message> messages = messageRepository.findMessagesByCoupleOfUsersAfterEpoch(
                Instant.ofEpochSecond(getNewMessagesRequestDTO.lastMessageEpochInSec()),
                getNewMessagesRequestDTO.firstPlatformUserId(),
                getNewMessagesRequestDTO.secondPlatformUserId());
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
