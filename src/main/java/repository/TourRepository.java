package repository;

import domain.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Long> {

    List<Tour> findByIdAndStatus(Long id, Tour.TourStatus status);
}
