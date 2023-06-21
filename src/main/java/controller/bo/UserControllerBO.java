package controller.bo;

import aspects.logging.Log;
import dto.bo.CreateUserRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.bo.UserServiceBO;

@RestController
@RequestMapping(value = "/bo/user", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class UserControllerBO {

    private final UserServiceBO userServiceBO;

    @PostMapping("/create")
    @Log
    public ResponseEntity<?> create(@RequestBody CreateUserRequestDTO request){
        userServiceBO.create(request);
        return ResponseEntity.ok().build();
    }
}
