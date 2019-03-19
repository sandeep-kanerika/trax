package com.trax.ratemanager.column.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;

@Service
public class ColumnValidationsService extends AbstractJpaService<RateColumnValidation>{

	@Autowired
	ColumnValidationsRepository columnValidationsRepository;
	
	@Override
	protected RateColumnValidation create(RateColumnValidation columnValidations) {
		// TODO Auto-generated method stub
		return save(columnValidations);
	}

	@Override
	protected RateColumnValidation update(RateColumnValidation _columnValidations) {
		// TODO Auto-generated method stub
		RateColumnValidation columnValidations = getById(_columnValidations.getId());
        if (columnValidations != null) {
        	return save(_columnValidations);
        }else {
        	throw new ResourceNotFoundException("columnValidations Id Not Found !");
        }
	}

	@Override
	protected RateColumnValidation delete(RateColumnValidation columnValidations) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<RateColumnValidation> search(RateColumnValidation columnValidations) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AbstractJpaRepository<RateColumnValidation, String> getRepository() {
		// TODO Auto-generated method stub
		return columnValidationsRepository;
	}

	public RateColumnValidation getById(String id) {
		// TODO Auto-generated method stub
		return columnValidationsRepository.getById(id);
	}

}
