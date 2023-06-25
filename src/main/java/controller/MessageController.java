package controller;

import dto.GetNewMessagesRequestDTO;
import dto.GetNewMessagesResponseDTO;
import dto.MessageDTO;
import dto.SendMessageRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.MessageService;

import java.util.List;

@RestController
@RequestMapping(value = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping
    public ResponseEntity<GetNewMessagesResponseDTO> getNewMessages(
            @RequestBody @Valid GetNewMessagesRequestDTO getNewMessagesRequestDTO){
        List<MessageDTO> newMessages = messageService.getNewMessages(getNewMessagesRequestDTO);
        return ResponseEntity.ok(new GetNewMessagesResponseDTO(newMessages));
    }

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody @Valid SendMessageRequestDTO sendMessageRequestDTO){
        messageService.sendMessage(sendMessageRequestDTO);
        return ResponseEntity.ok().build();
    }
}
