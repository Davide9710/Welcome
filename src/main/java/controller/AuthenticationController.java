package controller;

import dto.AuthenticationRequestDTO;
import dto.AuthenticationResponseDTO;
import dto.AuthenticationResponseJwtDTO;
import dto.RegisterRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.AuthenticationService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthenticationService authenticationService;

    @PostMapping("/register")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<AuthenticationResponseDTO> register(
            @RequestBody RegisterRequestDTO request
    ) {

        AuthenticationResponseJwtDTO authenticate = authenticationService.register(request);
        return ResponseEntity.ok()
                .headers(authenticationService.putJwtInHttpHeaders(authenticate.jwt()))
                .body(new AuthenticationResponseDTO(authenticate.user()));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> authenticate(
            @RequestBody AuthenticationRequestDTO request
    ) {
        AuthenticationResponseJwtDTO authenticate = authenticationService.authenticate(request);
        return ResponseEntity.ok()
                .headers(authenticationService.putJwtInHttpHeaders(authenticate.jwt()))
                .body(new AuthenticationResponseDTO(authenticate.user()));
    }
}
