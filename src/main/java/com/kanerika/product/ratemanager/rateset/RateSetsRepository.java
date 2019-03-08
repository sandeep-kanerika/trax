package com.kanerika.product.ratemanager.rateset;

import org.springframework.stereotype.Repository;

import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface RateSetsRepository extends AbstractJpaRepository<RateSets, String> {
	
	RateSets getById(String id);

}
