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
	protected RateTableDefinition create(RateTableDefinition rateTablesDefinition) {
		return save(rateTablesDefinition);
	}

	@Override
	protected RateTableDefinition update(RateTableDefinition _rateTables) {
//		return update(rateTables);
		RateTableDefinition rateTablesDefinition = getById(_rateTables.getId());
		if(rateTablesDefinition != null)
			return save(_rateTables);
		else {
			throw new ResourceNotFoundException("RateTablesDefinition Id Doesn't Exists !");
		}
	}

	@Override
	protected RateTableDefinition delete(RateTableDefinition rateTablesDefinition) {
		return delete(rateTablesDefinition);
	}

	@Override
	protected List<RateTableDefinition> search(RateTableDefinition rateTablesDefinition) {
		return this.search(rateTablesDefinition);
	}

	@Override
	protected AbstractJpaRepository<RateTableDefinition, String> getRepository() {
		return this.rateTablesDefinitionRepository;
	}

	public RateTableDefinition getById(String id) {
		return rateTablesDefinitionRepository.getById(id);
	}

}
