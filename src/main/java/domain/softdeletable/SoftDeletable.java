package domain.softdeletable;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * Annotation that groups the soft deletable annotations, it requires composition with SoftDelete Entity
 */
@SQLDelete(sql = "UPDATE #{#entityName} SET status = 'DELETED' WHERE id = ?")
@Where(clause = "soft_delete.status <> 'DELETED'")
public @interface SoftDeletable {
}
