package controller;

import domain.Theme;
import dto.GetAllThemeResponseDTO;
import lombok.RequiredArgsConstructor;
import mapper.ThemeResponseDTOMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ThemeService;

import java.util.List;

@RestController
@RequestMapping(value = "/theme", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ThemeController {
    private final ThemeService themeService;

    @GetMapping
    public ResponseEntity<GetAllThemeResponseDTO> getAll(){
        List<Theme> themes = themeService.getAll();
        return ResponseEntity.ok(new GetAllThemeResponseDTO(ThemeResponseDTOMapper.INSTANCE.convert(themes)));
    }
}
