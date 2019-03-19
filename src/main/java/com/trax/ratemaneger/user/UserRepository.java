package com.trax.ratemaneger.utility;

import org.springframework.stereotype.Repository;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

/**
 * Created by sudhakar.rao on 2/19/2019.
 */
@Repository
public interface CreateByUserRepository extends AbstractJpaRepository<CreatedByUser, String> {
	
}
