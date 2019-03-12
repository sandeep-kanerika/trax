package com.trax.ratemanager.column.validation;

import org.springframework.stereotype.Repository;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface ColumnValidationsRepository extends AbstractJpaRepository<ColumnValidations, String> {

	ColumnValidations getById(String id);
}
