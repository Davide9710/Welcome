package repository;

import domain.Tour;
import domain.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TouristRepository  extends JpaRepository<Tourist, Long> {
}
