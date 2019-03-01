package com.kanerika.product.ratemanager.amendment;

import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;

import java.math.BigInteger;

import org.springframework.stereotype.Repository;

/**
 * Created by sudhakar.rao on 2/19/2019.
 */
@Repository
public interface AmendmentsRepository extends AbstractJpaRepository<Amendments, Long> {
	
    Amendments getById(Long id);
}
