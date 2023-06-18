package specification;

import domain.Tour;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

public class SpecificationUtils {
    public static <T> Predicate inPredicate(Predicate p, Root<Tour> root, CriteriaBuilder cb, String fieldName, List<T> listOfValues) {
        return isEmpty(listOfValues) ? p : root.get(fieldName).in(listOfValues);
    }

    public static <T> Predicate equalWithNullControl(Predicate p,
                                                     CriteriaBuilder cb,
                                                     Expression<?> expression,
                                                     T value) {
        return value == null ? p : cb.equal(expression, value);
    }

    public static <T extends Comparable<? super T>> Predicate lessThanWithNullControl(Predicate p,
                                                                                      CriteriaBuilder cb,
                                                                                      Expression<? extends T> expression,
                                                                                      T value) {
        return value == null ? p : cb.lessThanOrEqualTo(expression, value);
    }
}
