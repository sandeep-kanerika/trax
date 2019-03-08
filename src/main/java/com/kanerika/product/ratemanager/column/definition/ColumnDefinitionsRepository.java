package com.kanerika.product.ratemanager.column.definition;

import org.springframework.stereotype.Repository;

import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface ColumnDefinitionsRepository extends AbstractJpaRepository<ColumnDefinitions, String> {
	
	ColumnDefinitions getById(String id);
}