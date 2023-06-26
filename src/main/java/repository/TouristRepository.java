package repository;

import domain.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Tourist repository that use JPA to access db data
 */
public interface TouristRepository  extends JpaRepository<Tourist, Long> {
}
