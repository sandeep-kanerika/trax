package com.kanerika.product.ratemanager.column.definition;

import java.math.BigInteger;

import org.springframework.stereotype.Repository;

import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface ColumnDefinitionsRepository extends AbstractJpaRepository<ColumnDefinitions, Long> {
	
	ColumnDefinitions getById(Long id);
}