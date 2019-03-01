package com.kanerika.product.ratemanager.jpa;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by sudhakar.rao on 2/4/2019.
 */
public class RateManagerJpaRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
        implements AbstractJpaRepository<T, ID> {

    private final EntityManager entityManager;

    public RateManagerJpaRepositoryImpl(JpaEntityInformation entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void refresh(T t) {
        entityManager.refresh(t);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}