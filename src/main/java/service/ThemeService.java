package service;

import domain.Theme;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.ThemeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThemeService {
    private final ThemeRepository themeRepository;

    /**
     * method that return all the themes in the db
     * @return the themes in the db
     */
    public List<Theme> getAll(){
        return themeRepository.findAll();
    }

}
