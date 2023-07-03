package repository;

import domain.softdeletable.SoftDelete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftDeleteRepository extends JpaRepository<SoftDelete, Long> {
}
