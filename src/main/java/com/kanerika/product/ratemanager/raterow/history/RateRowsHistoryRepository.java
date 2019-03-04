package com.kanerika.product.ratemanager.raterow.history;

import java.math.BigInteger;

import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;

public interface RateRowsHistoryRepository extends AbstractJpaRepository<RateRowsHistory, Long> {
	
	RateRowsHistory getById(Long id);

}
