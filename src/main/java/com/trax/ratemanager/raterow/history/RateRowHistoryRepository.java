package com.trax.ratemanager.raterow.history;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

public interface RateRowHistoryRepository extends AbstractJpaRepository<RateRowHistory, String>
{

	RateRowHistory getById(String id);

}
