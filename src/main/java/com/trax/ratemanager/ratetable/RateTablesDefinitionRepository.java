package com.trax.ratemanager.ratetable;

import org.springframework.stereotype.Repository;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface RateTablesDefinitionRepository extends AbstractJpaRepository<RateTablesDefinition, String> {
	
	RateTablesDefinition getById(String id);
}
