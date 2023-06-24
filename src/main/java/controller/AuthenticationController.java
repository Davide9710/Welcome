package controller;

import dto.AuthenticationRequestDTO;
import dto.AuthenticationResponseDTO;
import dto.AuthenticationResponseJwtDTO;
import dto.RegisterRequestDTO;
import dto.ResetPasswordRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.auth.AuthenticationService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register(
            @RequestBody @Valid RegisterRequestDTO request
    ) {

        AuthenticationResponseJwtDTO authenticate = authenticationService.register(request);
        return ResponseEntity.ok()
                .headers(authenticationService.putJwtInHttpHeaders(authenticate.jwt()))
                .body(new AuthenticationResponseDTO(authenticate.user()));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> authenticate(
            @RequestBody @Valid AuthenticationRequestDTO request
    ) {
        AuthenticationResponseJwtDTO authenticate = authenticationService.authenticate(request);
        return ResponseEntity.ok()
                .headers(authenticationService.putJwtInHttpHeaders(authenticate.jwt()))
                .body(new AuthenticationResponseDTO(authenticate.user()));
    }

    @GetMapping("/reset-psw")
    public ResponseEntity<?> resetPassword(
            @RequestBody @Valid ResetPasswordRequestDTO request
    ) {
        authenticationService.resetPassword(request);
        return ResponseEntity.ok().build();
    }
}
