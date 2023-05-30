package specification;

import domain.City_;
import domain.Theme_;
import domain.Tour;
import domain.Tour_;
import dto.SearchTourRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import static specification.SpecificationUtils.inPredicate;

@AllArgsConstructor
public class SearchTourSpecification implements Specification<Tour> {

    private final SearchTourRequestDTO filter;

    @Override
    public Predicate toPredicate(Root<Tour> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate p = cb.and();
        p = cb.and(p, cb.equal(root.get(Tour_.city).get(City_.ID), filter.cityId()));
        p = cb.and(p, cb.lessThan(root.get(Tour_.approxDuration), filter.duration()));
        p = cb.and(p, cb.equal(root.get(Tour_.theme).get(Theme_.ID), filter.themeName()));
        p = cb.and(p, inPredicate(root, cb, Tour_.TAGS, filter.tagNames()));
        return p;
    }
}
