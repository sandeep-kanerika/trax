package com.trax.ratemanager.column.defination;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.amendment.AmendmentRepository;
import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;

@Service
public class ColumnDefinitionsService extends AbstractJpaService<RateColumnDefinition> {

	@Autowired
	ColumnDefinitionsRepository columnDefinitionsrepository;

	@Override
	protected RateColumnDefinition create(RateColumnDefinition columndefinition) {
		// TODO Auto-generated method stub
		return save(columndefinition);
	}

	@Override
	protected RateColumnDefinition update(RateColumnDefinition colDef) {
		// TODO Auto-generated method stub
		RateColumnDefinition columnDefinitions = getById(colDef.getId());
		if(columnDefinitions != null) {
			return save(colDef);
		}else {
			throw new ResourceNotFoundException("ColumnDefinitions Id Doesn't Exists !");
		}
	}

	@Override
	protected RateColumnDefinition delete(RateColumnDefinition t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<RateColumnDefinition> search(RateColumnDefinition t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AbstractJpaRepository<RateColumnDefinition, String> getRepository() {
		// TODO Auto-generated method stub
		return columnDefinitionsrepository;
	}
	
    public RateColumnDefinition getById(String id) {
//		return search(id);
    	return columnDefinitionsrepository.getById(id);
    }

}
