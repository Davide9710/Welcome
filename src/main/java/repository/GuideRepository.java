package repository;

import domain.Guide;
import domain.Tour;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GuideRepository extends JpaRepository<Guide, Long> {

    @Query("select tour from Guide g inner join g.tours tour where g.id = :guideId")
    List<Tour> findTourByGuideId(@Param("guideId") Long guideId, Pageable pageable);
}
