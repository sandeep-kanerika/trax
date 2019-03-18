package com.trax.ratemanager.column.defination;

import org.springframework.stereotype.Repository;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface ColumnDefinitionsRepository extends AbstractJpaRepository<ColumnDefinition, String> {
	
	ColumnDefinition getById(String id);
}