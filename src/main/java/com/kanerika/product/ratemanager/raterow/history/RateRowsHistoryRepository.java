package com.kanerika.product.ratemanager.raterow.history;

import java.math.BigInteger;

import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;

public interface RateRowsHistoryRepository extends AbstractJpaRepository<RateRowsHistory, String> {
	
	RateRowsHistory getById(String id);

}
