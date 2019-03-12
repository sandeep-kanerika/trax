package com.trax.ratemanager.raterow;

import org.springframework.stereotype.Repository;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface RateRowsRepository extends AbstractJpaRepository<RateRows, String> {
	
	RateRows getById(String id);

}
