package repository;

import domain.PlatformUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PlatformUser repository that use JPA to access db data
 */
public interface PlatformUserRepository extends JpaRepository<PlatformUser, Long> {
}
