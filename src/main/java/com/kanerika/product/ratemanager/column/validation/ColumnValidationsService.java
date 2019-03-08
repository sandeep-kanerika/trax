package com.kanerika.product.ratemanager.column.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanerika.product.ratemanager.exception.ResourceNotFoundException;
import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;
import com.kanerika.product.ratemanager.jpa.AbstractJpaService;

@Service
public class ColumnValidationsService extends AbstractJpaService<ColumnValidations>{

	@Autowired
	ColumnValidationsRepository columnValidationsRepository;
	
	@Override
	protected ColumnValidations create(ColumnValidations columnValidations) {
		// TODO Auto-generated method stub
		return save(columnValidations);
	}

	@Override
	protected ColumnValidations update(ColumnValidations _columnValidations) {
		// TODO Auto-generated method stub
		ColumnValidations columnValidations = getById(_columnValidations.getId());
        if (columnValidations != null) {
        	return save(_columnValidations);
        }else {
        	throw new ResourceNotFoundException("columnValidations Id Not Found !");
        }
	}

	@Override
	protected ColumnValidations delete(ColumnValidations columnValidations) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<ColumnValidations> search(ColumnValidations columnValidations) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AbstractJpaRepository<ColumnValidations, String> getRepository() {
		// TODO Auto-generated method stub
		return columnValidationsRepository;
	}

	public ColumnValidations getById(String id) {
		// TODO Auto-generated method stub
		return columnValidationsRepository.getById(id);
	}

}
