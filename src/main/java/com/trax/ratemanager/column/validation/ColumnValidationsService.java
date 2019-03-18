package com.trax.ratemanager.column.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;

@Service
public class ColumnValidationsService extends AbstractJpaService<ColumnValidation>{

	@Autowired
	ColumnValidationsRepository columnValidationsRepository;
	
	@Override
	protected ColumnValidation create(ColumnValidation columnValidations) {
		// TODO Auto-generated method stub
		return save(columnValidations);
	}

	@Override
	protected ColumnValidation update(ColumnValidation _columnValidations) {
		// TODO Auto-generated method stub
		ColumnValidation columnValidations = getById(_columnValidations.getId());
        if (columnValidations != null) {
        	return save(_columnValidations);
        }else {
        	throw new ResourceNotFoundException("columnValidations Id Not Found !");
        }
	}

	@Override
	protected ColumnValidation delete(ColumnValidation columnValidations) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<ColumnValidation> search(ColumnValidation columnValidations) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AbstractJpaRepository<ColumnValidation, String> getRepository() {
		// TODO Auto-generated method stub
		return columnValidationsRepository;
	}

	public ColumnValidation getById(String id) {
		// TODO Auto-generated method stub
		return columnValidationsRepository.getById(id);
	}

}
