package com.kanerika.product.ratemanager.column.validation;

import org.springframework.stereotype.Repository;

import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface ColumnValidationsRepository extends AbstractJpaRepository<ColumnValidations, String> {

	ColumnValidations getById(String id);
}
