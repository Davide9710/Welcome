package repository;

import domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Tag repository that use JPA to access db data
 */
public interface TagRepository extends JpaRepository<Tag, Long> {
}
