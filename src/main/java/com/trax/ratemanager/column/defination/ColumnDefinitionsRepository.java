package com.trax.ratemanager.column.defination;

import org.springframework.stereotype.Repository;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface ColumnDefinitionsRepository extends AbstractJpaRepository<RateColumnDefinition, String> {
	
	RateColumnDefinition getById(String id);
}