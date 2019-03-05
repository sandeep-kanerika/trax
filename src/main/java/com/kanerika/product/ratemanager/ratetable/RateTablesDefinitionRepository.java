package com.kanerika.product.ratemanager.ratetable;

import org.springframework.stereotype.Repository;

import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface RateTablesDefinitionRepository extends AbstractJpaRepository<RateTablesDefinition, Long> {
	
	RateTablesDefinition getById(Long id);

}
