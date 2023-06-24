package repository;

import domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * City repository that use JPA to access db data
 */
public interface CityRepository extends JpaRepository<City, Long> {
}
