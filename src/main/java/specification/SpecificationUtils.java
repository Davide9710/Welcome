package specification;

import domain.Tour;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

public class SpecificationUtils {
    public static <T> Predicate inPredicate(Root<Tour> root, CriteriaBuilder cb, String fieldName, List<T> listOfValues) {
        return isEmpty(listOfValues) ? cb.conjunction() : root.get(fieldName).in(listOfValues);
    }
}
