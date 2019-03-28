package com.trax.ratemanager.jpa;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

/**
 * Created by sudhakar.rao on 2/4/2019.
 */
public abstract class AbstractJpaService<T> extends BaseJpaService<T> {
	
    public LocalDateTime getCurrentTimeStamp() {
        return LocalDateTime.now();
    }

    public T save(T t) {
        T result = getRepository().save(t);
        getRepository().refresh(result);
        return result;
    }

    public abstract T create(T t);

    public abstract T update(T t);

    public abstract T delete(T t);
    
    public abstract List<T> search(T t);

    public List<T> searchBySpecification(Specification<T> specification) {
        return getRepository().findAll(specification);
    }

    public Specification<T> getDefaultSearchSpecification(T t) {
        return new Specification<T>() {
			private static final long serialVersionUID = -9036852032496186842L;

			@Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return getPredicateForDefaultSearch(root, criteriaQuery, cb, t);
            }
        };
    }

    public Predicate getPredicateForDefaultSearch(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb, T t) {
        return null;
    }

}
