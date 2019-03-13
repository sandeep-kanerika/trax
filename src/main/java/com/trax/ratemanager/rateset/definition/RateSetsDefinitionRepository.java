package com.trax.ratemanager.rateset.definition;

import java.math.BigInteger;

import org.springframework.stereotype.Repository;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface RateSetsDefinitionRepository extends AbstractJpaRepository<RateSetsDefinition, String> {
	
	RateSetsDefinition getById(String id);

}