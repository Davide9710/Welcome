package specification;

import domain.Tour;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

/**
 * an utils generic methods to help the creation of Java Specification
 */
public class SpecificationUtils {
    /**
     * @param root         query root
     * @param fieldName    the name of the fields to be selected
     * @param listOfValues the list of values to run against the "IN" query
     * @param <T>          generic value
     * @return the predicate with the "IN" query if the listOfValues is not empty, else it returns the given predicate
     */
    public static <T> Predicate inPredicate(CriteriaBuilder cb, Root<Tour> root, String fieldName, List<T> listOfValues) {
        return isEmpty(listOfValues) ? cb.conjunction() : root.get(fieldName).in(listOfValues);
    }

    /**
     * Method used for the equal criteria query, with null check
     *
     * @param cb         criteria builder
     * @param expression expression to be equal
     * @param value      value to be equal
     * @param <T>        generic
     * @return predicate, if value is not null
     */
    public static <T> Predicate equalWithNullControl(CriteriaBuilder cb,
                                                     Expression<?> expression,
                                                     T value) {
        return value == null ? cb.conjunction() : cb.equal(expression, value);
    }

    /**
     * Method used for the "less than" criteria query, with null check
     *
     * @param cb         criteria builder
     * @param expression expression to be equal
     * @param value      value to be equal
     * @param <T>        generic
     * @return predicate, if value is not null
     */
    public static <T extends Comparable<? super T>> Predicate greaterThanOrEqualTo(CriteriaBuilder cb,
                                                                                   Expression<? extends T> expression,
                                                                                   T value) {
        return value == null ? cb.conjunction() : cb.greaterThanOrEqualTo(expression, value);
    }
}
