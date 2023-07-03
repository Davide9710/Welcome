package repository;


import domain.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Theme repository that use JPA to access db data
 */
public interface ThemeRepository extends JpaRepository<Theme, Long> {
    Optional<Theme> findByName(String themeName);
}
