package controller;

import dto.request.AuthenticationRequestDTO;
import dto.response.AuthenticationResponseDTO;
import dto.response.AuthenticationResponseJwtDTO;
import dto.RegisterRequestDTO;
import dto.request.ResetPasswordRequestDTO;
import exception.WrongRoleException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Operation(summary = "Register a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Registration Successful"),
            @ApiResponse(responseCode = "400", description = "Invalid request payload"),
            @ApiResponse(responseCode = "409", description = "User's email already registered"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<AuthenticationResponseDTO> register(
            @RequestBody @Valid RegisterRequestDTO request
    ) {
        if(request.role().equals(Role.ADMIN)) throw new WrongRoleException();
        AuthenticationResponseJwtDTO authenticate = authenticationService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(authenticationService.putJwtInHttpHeaders(authenticate.jwt()))
                .body(new AuthenticationResponseDTO(authenticate.user()));
    }

    /**
     * Post Endpoint that authenticate the user with the given credentials
     * @param request credentials
     * @return Response Entity indicating the auth result
     */
    @PostMapping("/authenticate")
    @Operation(summary = "Authenticate the user with the given credentials")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authentication Successful"),
            @ApiResponse(responseCode = "401", description = "Invalid Credentials"),
            @ApiResponse(responseCode = "404", description = "Resource not found"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<AuthenticationResponseDTO> authenticate(
            @RequestBody @Valid AuthenticationRequestDTO request
    ) {
        AuthenticationResponseJwtDTO authenticate = authenticationService.authenticate(request);
        return ResponseEntity.ok()
                .headers(authenticationService.putJwtInHttpHeaders(authenticate.jwt()))
                .body(new AuthenticationResponseDTO(authenticate.user()));
    }

    /**
     * Post Endpoint that reset the password
     * @param request user's email
     * @return Response Entity indicating the reset password result
     */
    @PostMapping("/reset-psw")
    @Operation(summary = "Reset the password")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Password reset Successful"),
            @ApiResponse(responseCode = "404", description = "Email not found"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<?> resetPassword(
            @RequestBody @Valid ResetPasswordRequestDTO request
    ) {
        authenticationService.resetPassword(request);
        return ResponseEntity.ok().build();
    }
}
