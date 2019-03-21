package com.trax.ratemanager.column.validation;

import org.springframework.stereotype.Repository;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface ColumnValidationRepository extends AbstractJpaRepository<ColumnValidation, String> {

	ColumnValidation getById(String id);
}
