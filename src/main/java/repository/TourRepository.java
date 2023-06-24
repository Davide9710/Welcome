package repository;

import domain.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import value.Status;

import java.util.List;

/**
 * Tour repository that use JPA to access db data
 */
public interface TourRepository extends JpaRepository<Tour, Long>, JpaSpecificationExecutor<Tour> {

    List<Tour> findByIdAndStatus(Long id, Status status);
}
