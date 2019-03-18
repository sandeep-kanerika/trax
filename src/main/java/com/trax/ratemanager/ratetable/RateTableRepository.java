package com.trax.ratemanager.ratetable;

import org.springframework.stereotype.Repository;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface RateTableRepository extends AbstractJpaRepository<RateTable, String> {

	RateTable getById(String id);
}
