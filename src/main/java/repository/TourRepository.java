package repository;

import domain.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import value.Status;

import java.util.List;

/**
 * Tour repository that use JPA to access db data
 */
public interface TourRepository extends JpaRepository<Tour, Long>, JpaSpecificationExecutor<Tour> {

    @Query(value = "select t " +
            "from Tour t join SoftDelete s on t.softDelete.id = s.id " +
            "where s.status = :status and t.id = :id")
    List<Tour> findTourByIdAndStatus(Long id, Status status);
}
