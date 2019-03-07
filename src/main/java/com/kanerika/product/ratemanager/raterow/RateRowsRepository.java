package com.kanerika.product.ratemanager.raterow;

import org.springframework.stereotype.Repository;

import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface RateRowsRepository extends AbstractJpaRepository<RateRows, Long> {
	
	RateRows getById(Long id);

}
