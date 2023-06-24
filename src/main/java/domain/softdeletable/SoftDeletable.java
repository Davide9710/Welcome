package domain.softdeletable;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import value.Status;

@Entity
@SQLDelete(sql = "UPDATE #{#entityName} SET status = 'DELETED' WHERE id = ?")
@Where(clause = "status <> 'DELETED'")
public abstract class SoftDeletable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Status status = Status.ACTIVE;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
