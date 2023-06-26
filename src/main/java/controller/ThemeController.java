package controller;

import domain.Theme;
import dto.response.GetAllThemeResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import mapper.theme.ThemeResponseDTOMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ThemeService;

import java.util.List;

/**
 * This controller contains theme-related endpoints, it requires GUIDE or TOURIST role
 */
@RestController
@RequestMapping(value = "/theme", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('GUIDE', 'TOURIST')")
public class ThemeController {
    private final ThemeService themeService;

    /**
     * Get Endpoint that return all the themes in the db
     * @return the themes in the db
     */
    @GetMapping
    @Operation(summary = "get all themes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<GetAllThemeResponseDTO> getAll(){
        List<Theme> themes = themeService.getAll();
        return ResponseEntity.ok(new GetAllThemeResponseDTO(ThemeResponseDTOMapper.INSTANCE.convert(themes)));
    }
}
