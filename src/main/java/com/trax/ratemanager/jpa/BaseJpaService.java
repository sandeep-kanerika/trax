package com.trax.ratemanager.jpa;

/**
 * Created by sudhakar.rao on 2/4/2019.
 */
public abstract class BaseJpaService<T>
{
	public abstract AbstractJpaRepository<T, String> getRepository();
}
