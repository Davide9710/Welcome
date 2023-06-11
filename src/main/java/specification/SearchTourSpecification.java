package specification;

import domain.City_;
import domain.Theme_;
import domain.Tour;
import domain.Tour_;
import dto.SearchTourRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import static specification.SpecificationUtils.*;

@AllArgsConstructor
public class SearchTourSpecification implements Specification<Tour> {

    private final SearchTourRequestDTO filter;

    @Override
    public Predicate toPredicate(Root<Tour> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate p = cb.and();
        p = cb.and(equalWithNullControl(p, cb, root.get(Tour_.city).get(City_.ID), filter.cityId()));
        p = cb.and(lessThanWithNullControl(p, cb, root.get(Tour_.approxDuration), filter.maxDuration()));
        p = cb.and(equalWithNullControl(p, cb, root.get(Tour_.theme).get(Theme_.NAME), filter.themeName()));
        p = cb.and(inPredicate(p, root, cb, Tour_.TAGS, filter.tagNames()));
        return p;
    }
}
