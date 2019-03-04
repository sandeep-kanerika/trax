package com.kanerika.product.ratemanager.column.validation;

import java.math.BigInteger;

import org.springframework.stereotype.Repository;
import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface ColumnValidationsRepository extends AbstractJpaRepository<ColumnValidations, Long> {
	
	ColumnValidations getById(Long id);
}
