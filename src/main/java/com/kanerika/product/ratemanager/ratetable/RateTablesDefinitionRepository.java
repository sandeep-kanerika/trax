package com.kanerika.product.ratemanager.ratetable;

import org.springframework.stereotype.Repository;

import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface RateTablesDefinitionRepository extends AbstractJpaRepository<RateTablesDefinition, String> {
	
	RateTablesDefinition getById(String id);
}
