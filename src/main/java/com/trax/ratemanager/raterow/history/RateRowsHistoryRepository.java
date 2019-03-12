package com.trax.ratemanager.raterow.history;

import java.math.BigInteger;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

public interface RateRowsHistoryRepository extends AbstractJpaRepository<RateRowsHistory, String> {
	
	RateRowsHistory getById(String id);

}
