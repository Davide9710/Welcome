package domain;

import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import value.Status;

@MappedSuperclass
@SQLDelete(sql = "UPDATE #{#entityName} SET status = 'DELETED' WHERE id = ?")
@Where(clause = "status <> 'DELETED'")
public abstract class SoftDeletable {
    private Status status = Status.ACTIVE;
}
