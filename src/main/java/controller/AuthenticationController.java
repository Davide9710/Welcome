package controller;

import dto.AuthenticationRequestDTO;
import dto.AuthenticationResponseDTO;
import dto.AuthenticationResponseJwtDTO;
import dto.RegisterRequestDTO;
import dto.ResetPasswordRequestDTO;
import exception.WrongRoleException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.auth.AuthenticationService;
import value.Role;

/**
 * Controller that defined authentication's endpoint, reachable without auth
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    /**
     * Post Endpoint to register a new user
     * @param request the username, password and Role
     * @return Response Entity with the jwt token and the user's email
     */
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register(
            @RequestBody @Valid RegisterRequestDTO request
    ) {
        if(request.role().equals(Role.ADMIN)) throw new WrongRoleException();
        AuthenticationResponseJwtDTO authenticate = authenticationService.register(request);
        return ResponseEntity.ok()
                .headers(authenticationService.putJwtInHttpHeaders(authenticate.jwt()))
                .body(new AuthenticationResponseDTO(authenticate.user()));
    }

    /**
     * Post Endpoint that authenticate the user with the given credentials
     * @param request credentials
     * @return Response Entity indicating the auth result
     */
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> authenticate(
            @RequestBody @Valid AuthenticationRequestDTO request
    ) {
        AuthenticationResponseJwtDTO authenticate = authenticationService.authenticate(request);
        return ResponseEntity.ok()
                .headers(authenticationService.putJwtInHttpHeaders(authenticate.jwt()))
                .body(new AuthenticationResponseDTO(authenticate.user()));
    }

    /**
     * Get Endpoint that reset the password
     * @param request user's email
     * @return Response Entity indicating the reset password result
     */
    @GetMapping("/reset-psw")
    public ResponseEntity<?> resetPassword(
            @RequestBody @Valid ResetPasswordRequestDTO request
    ) {
        authenticationService.resetPassword(request);
        return ResponseEntity.ok().build();
    }
}
