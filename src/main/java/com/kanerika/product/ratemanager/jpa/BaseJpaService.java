package com.kanerika.product.ratemanager.jpa;

/**
 * Created by sudhakar.rao on 2/4/2019.
 */
public abstract class BaseJpaService<T> {
    protected abstract AbstractJpaRepository<T, Long> getRepository();
}
