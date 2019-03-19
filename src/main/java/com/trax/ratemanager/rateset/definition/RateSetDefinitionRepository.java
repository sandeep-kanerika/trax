package com.trax.ratemanager.rateset.definition;

import java.math.BigInteger;

import org.springframework.stereotype.Repository;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface RateSetDefinitionRepository extends AbstractJpaRepository<RateSetDefinition, String> {
	
	RateSetDefinition getById(String id);

}
