package controller;

import dto.response.GetNewMessagesResponseDTO;
import dto.MessageDTO;
import dto.request.SendMessageRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.MessageService;

import java.util.List;

/**
 * Controller that contains messages endpoint, it requires GUIDE or TOURIST role
 */
@RestController
@RequestMapping(value = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('GUIDE', 'TOURIST')")
public class MessageController {
    private final MessageService messageService;

    /**
     * Endpoint that return new messages, given the users and the epoch of last message
     * @param epoch epoch in seconds form 1970
     * @param firstId id of the first user
     * @param secondId id of the second user
     * @return list of new messages
     */
    @GetMapping("/new")
    @Operation(summary = "get all new messages")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<GetNewMessagesResponseDTO> getNewMessages(@RequestParam("epoch") Long epoch,
                                                                    @RequestParam("firstId") Long firstId,
                                                                    @RequestParam("secondId") Long secondId){
        List<MessageDTO> newMessages = messageService.getNewMessages(epoch, firstId, secondId);
        return ResponseEntity.ok(new GetNewMessagesResponseDTO(newMessages));
    }

    /**
     * Method that send a new message
     * @param sendMessageRequestDTO message data, sender and receiver
     * @return response entity
     */
    @PostMapping("/send")
    @Operation(summary = "send message")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "PlatformUserNotFoundException, User not found"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<?> sendMessage(@RequestBody @Valid SendMessageRequestDTO sendMessageRequestDTO){
        messageService.sendMessage(sendMessageRequestDTO);
        return ResponseEntity.ok().build();
    }
}
