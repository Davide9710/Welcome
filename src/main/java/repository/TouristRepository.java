package repository;

import domain.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristRepository  extends JpaRepository<Tourist, Long> {
}
