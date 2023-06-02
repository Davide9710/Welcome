package domain;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import value.Status;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@SQLDelete(sql = "UPDATE #{#entityName} SET status = 'DELETED' WHERE id = ?")
@Where(clause = "status <> 'DELETED'")
public abstract class SoftDeletable {
    private Status status = Status.ACTIVE;
}
