package com.trax.ratemanager.column.definition;

import org.springframework.stereotype.Repository;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface ColumnDefinitionsRepository extends AbstractJpaRepository<ColumnDefinitions, String> {
	
	ColumnDefinitions getById(String id);
}