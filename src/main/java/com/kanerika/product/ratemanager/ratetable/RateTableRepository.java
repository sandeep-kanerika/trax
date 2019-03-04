package com.kanerika.product.ratemanager.ratetable;

import org.springframework.stereotype.Repository;

import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface RateTableRepository extends AbstractJpaRepository<RateTable, Long> {
	
	RateTable getById(Long id);

}
