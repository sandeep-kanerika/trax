package com.trax.ratemanager.ratetable.definition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;

@Repository
public class RateTableDefinitionService extends AbstractJpaService<RateTableDefinition> {

	@Autowired
	RateTableDefinitionRepository rateTablesDefinitionRepository;

	@Override
	public RateTableDefinition create(RateTableDefinition rateTablesDefinition) {
		return save(rateTablesDefinition);
	}

	@Override
	public RateTableDefinition update(RateTableDefinition _rateTables) {
//		return update(rateTables);
		RateTableDefinition rateTablesDefinition = getById(_rateTables.getId());
		if (rateTablesDefinition != null)
			return save(_rateTables);
		else {
			throw new ResourceNotFoundException("RateTablesDefinition Id Doesn't Exists !");
		}
	}

	@Override
	public RateTableDefinition delete(RateTableDefinition rateTablesDefinition) {
		rateTablesDefinitionRepository.delete(rateTablesDefinition);
		return rateTablesDefinition;
	}

	@Override
	public List<RateTableDefinition> search(RateTableDefinition rateTablesDefinition) {
		return this.search(rateTablesDefinition);
	}

	@Override
	public AbstractJpaRepository<RateTableDefinition, String> getRepository() {
		return this.rateTablesDefinitionRepository;
	}

	public RateTableDefinition getById(String id) {
		return rateTablesDefinitionRepository.getById(id);
	}

	public void deleteById(String id) {
		rateTablesDefinitionRepository.deleteById(id);
	}

	public List<RateTableDefinition> findAll() {
		return rateTablesDefinitionRepository.findAll();
	}

}
