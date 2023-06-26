package repository;

import domain.TourStop;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TourStop repository that use JPA to access db data
 */
public interface TourStopRepository extends JpaRepository<TourStop, Long> {
}
