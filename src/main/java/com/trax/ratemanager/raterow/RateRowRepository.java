package com.trax.ratemanager.raterow;

import org.springframework.stereotype.Repository;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface RateRowRepository extends AbstractJpaRepository<RateRow, String> {
	
	RateRow getById(String id);

}
