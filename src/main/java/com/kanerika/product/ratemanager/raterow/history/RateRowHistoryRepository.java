package com.kanerika.product.ratemanager.raterow.history;

import java.math.BigInteger;

import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;

public interface RateRowHistoryRepository extends AbstractJpaRepository<RateRowHistory, Long> {
	
	RateRowHistory getById(BigInteger id);

}
