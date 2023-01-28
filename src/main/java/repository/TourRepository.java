package repository;

import domain.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Long> {

    List<Tour> findByIdAndTourStatus(Long id, Tour.TourStatus active);
}
