package repository;

import domain.TourStop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourStopRepository extends JpaRepository<TourStop, Long> {
}
