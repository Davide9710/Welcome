package domain.softdeletable;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * Annotation that groups the soft deletable annotations
 */
@SQLDelete(sql = "UPDATE #{#entityName} SET status = 'DELETED' WHERE id = ?")
@Where(clause = "status <> 'DELETED'")
public @interface SoftDeletable {
}
