package repository;

import domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Image repository that use JPA to access db data
 */
public interface ImageRepository extends JpaRepository<Image, Long> {
}
