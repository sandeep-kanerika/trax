package com.kanerika.product.ratemanager.rateset;

import java.math.BigInteger;

import org.springframework.stereotype.Repository;
import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface RateSetsRepository extends AbstractJpaRepository<RateSets, Long> {
	
	RateSets getById(Long id);

}
