package repository;


import domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Review repository that use JPA to access db data
 */
public interface ReviewRepository  extends JpaRepository<Review, Long>{
}
