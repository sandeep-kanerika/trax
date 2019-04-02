package com.trax.ratemanager.ratetable.definition;

import org.springframework.stereotype.Repository;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface RateTableDefinitionRepository extends AbstractJpaRepository<RateTableDefinition, String>
{

	RateTableDefinition getById(String id);
}
