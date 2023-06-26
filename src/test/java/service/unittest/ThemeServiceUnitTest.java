package service.unittest;

import domain.Theme;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import repository.ThemeRepository;
import service.ThemeService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ThemeServiceUnitTest {
    @SpringBootConfiguration
    static class TestConfig {
        @Autowired
        ThemeRepository themeRepository;

        @Bean
        public ThemeService themeService() {
            return new ThemeService(themeRepository);
        }
    }

    @MockBean
    ThemeRepository themeRepository;

    @Autowired
    ThemeService themeService;

    @Test
    public void getAllTest(){
        //given
        Theme mockTheme = new Theme();
        String mockThemeName = "mockThemeName";
        mockTheme.setName(mockThemeName);
        Mockito.when(themeRepository.findAll()).thenReturn(List.of(mockTheme));

        //when
        List<Theme> allThemes = themeService.getAll();

        //then
        assertNotNull(allThemes);
        assertEquals(allThemes.size(), 1);
        assertNotNull(allThemes.get(0));
        assertEquals(allThemes.get(0).getName(), mockThemeName);
    }
}
