package controller.bo;

import aspects.logging.Log;
import domain.User;
import dto.bo.CreateUserRequestDTO;
import dto.bo.GetAllUserResponseDTO;
import lombok.RequiredArgsConstructor;
import mapper.user.UserDTOMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.bo.UserServiceBO;

import java.util.List;

/**
 * BO controller with utility endpoint about the user; it authorizes request only from the ADMIN role
 */
@RestController
@RequestMapping(value = "/bo/user", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class UserControllerBO {

    private final UserServiceBO userServiceBO;

    /**
     * Post Endpoint that creates a new city
     * @param request user data
     * @return Response Entity indicating the operation result
     */
    @PostMapping("/create")
    @Log
    public ResponseEntity<?> create(@RequestBody CreateUserRequestDTO request){
        userServiceBO.create(request);
        return ResponseEntity.ok().build();
    }

    /**
     * Get Endpoint that get all the users
     * @return a DTO projection of all the users
     */
    @GetMapping
    @Log
    public ResponseEntity<GetAllUserResponseDTO> getAll(){
        List<User> users = userServiceBO.getAll();
        return ResponseEntity.ok(new GetAllUserResponseDTO(UserDTOMapper.INSTANCE.convert(users)));
    }
}
