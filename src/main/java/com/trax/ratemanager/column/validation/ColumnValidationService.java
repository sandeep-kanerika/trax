package com.trax.ratemanager.column.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;

@Service
public class ColumnValidationService extends AbstractJpaService<ColumnValidation>{

	@Autowired
	ColumnValidationRepository columnValidationsRepository;
	
	@Override
	public ColumnValidation create(ColumnValidation columnValidations) {
		return save(columnValidations);
	}

	@Override
	public ColumnValidation update(ColumnValidation colVal) {
		ColumnValidation columnValidations = getById(colVal.getId());
        if (columnValidations != null) {
        	return save(colVal);
        }else {
        	throw new ResourceNotFoundException("columnValidations Id Not Found !");
        }
	}

	@Override
	public ColumnValidation delete(ColumnValidation columnValidations) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ColumnValidation> search(ColumnValidation columnValidations) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractJpaRepository<ColumnValidation, String> getRepository() {
		// TODO Auto-generated method stub
		return columnValidationsRepository;
	}

	public ColumnValidation getById(String id) {
		// TODO Auto-generated method stub
		return columnValidationsRepository.getById(id);
	}

}
