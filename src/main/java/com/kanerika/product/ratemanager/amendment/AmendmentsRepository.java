package com.kanerika.product.ratemanager.amendment;

import org.springframework.stereotype.Repository;

import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;

/**
 * Created by sudhakar.rao on 2/19/2019.
 */
@Repository
public interface AmendmentsRepository extends AbstractJpaRepository<Amendments, Long> {
	
    Amendments getById(Long id);
}
