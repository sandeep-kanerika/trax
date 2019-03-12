package com.trax.ratemanager.column.definition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.amendment.AmendmentsRepository;
import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;

@Service
public class ColumnDefinitionsService extends AbstractJpaService<ColumnDefinitions> {

	@Autowired
	ColumnDefinitionsRepository columnDefinitionsrepository;

	@Override
	protected ColumnDefinitions create(ColumnDefinitions columndefinition) {
		// TODO Auto-generated method stub
		return save(columndefinition);
	}

	@Override
	protected ColumnDefinitions update(ColumnDefinitions _columnDefinitions) {
		// TODO Auto-generated method stub
		ColumnDefinitions columnDefinitions = getById(_columnDefinitions.getId());
		if(columnDefinitions != null) {
			return save(_columnDefinitions);
		}else {
			throw new ResourceNotFoundException("ColumnDefinitions Id Doesn't Exists !");
		}
	}

	@Override
	protected ColumnDefinitions delete(ColumnDefinitions t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<ColumnDefinitions> search(ColumnDefinitions t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AbstractJpaRepository<ColumnDefinitions, String> getRepository() {
		// TODO Auto-generated method stub
		return columnDefinitionsrepository;
	}
	
    public ColumnDefinitions getById(String id) {
//		return search(id);
    	return columnDefinitionsrepository.getById(id);
    }

}
