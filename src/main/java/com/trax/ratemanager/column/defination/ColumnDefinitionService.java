package com.trax.ratemanager.column.defination;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;

@Service
public class ColumnDefinitionService extends AbstractJpaService<ColumnDefinition> {

	@Autowired
	ColumnDefinitionRepository columnDefinitionsrepository;

	@Override
	protected ColumnDefinition create(ColumnDefinition columndefinition) {
		// TODO Auto-generated method stub
		return save(columndefinition);
	}

	@Override
	protected ColumnDefinition update(ColumnDefinition colDef) {
		// TODO Auto-generated method stub
		ColumnDefinition columnDefinitions = getById(colDef.getId());
		if(columnDefinitions != null) {
			return save(colDef);
		}else {
			throw new ResourceNotFoundException("ColumnDefinitions Id Doesn't Exists !");
		}
	}

	@Override
	protected ColumnDefinition delete(ColumnDefinition t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<ColumnDefinition> search(ColumnDefinition t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AbstractJpaRepository<ColumnDefinition, String> getRepository() {
		// TODO Auto-generated method stub
		return columnDefinitionsrepository;
	}
	
    public ColumnDefinition getById(String id) {
//		return search(id);
    	return columnDefinitionsrepository.getById(id);
    }

}
