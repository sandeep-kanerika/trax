package com.trax.ratemanager.jpa;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by sudhakar.rao on 2/4/2019.
 */

@NoRepositoryBean
public interface AbstractJpaRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
    void refresh(T t);
    EntityManager getEntityManager();
}