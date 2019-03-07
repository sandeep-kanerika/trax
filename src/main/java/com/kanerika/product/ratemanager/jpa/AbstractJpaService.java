package com.kanerika.product.ratemanager.jpa;

import java.util.Date;
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
	
    public java.sql.Timestamp getCurrentTimeStamp() {
        Date today = new Date();
        return new java.sql.Timestamp(today.getTime());
    }

    protected T save(T t) {
        T result = getRepository().saveAndFlush(t);
        getRepository().refresh(result);
        return result;
    }

    protected abstract T create(T t);

    protected abstract T update(T t);

    protected abstract T delete(T t);
    
    protected abstract List<T> search(T t);

    protected List<T> searchBySpecification(Specification<T> specification) {
        return getRepository().findAll(specification);
    }

    protected Specification<T> getDefaultSearchSpecification(T t) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return getPredicateForDefaultSearch(root, criteriaQuery, cb, t);
            }
        };
    }

    protected Predicate getPredicateForDefaultSearch(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb, T t) {
        return null;
    }

}
