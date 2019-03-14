package com.trax.ratemanager.rateset;

import org.springframework.stereotype.Repository;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface RateSetsRepository extends AbstractJpaRepository<RateSets, String> {
	
	RateSets getById(String id);
}
