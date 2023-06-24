package repository;


import domain.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Theme repository that use JPA to access db data
 */
public interface ThemeRepository extends JpaRepository<Theme, Long> {
}
