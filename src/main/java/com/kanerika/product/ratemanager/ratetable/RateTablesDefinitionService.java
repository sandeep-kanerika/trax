package com.kanerika.product.ratemanager.ratetable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kanerika.product.ratemanager.exception.ResourceNotFoundException;
import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;
import com.kanerika.product.ratemanager.jpa.AbstractJpaService;

import jdk.nashorn.internal.runtime.FindProperty;

@Repository
public class RateTablesDefinitionService extends AbstractJpaService<RateTablesDefinition> {

	@Autowired
	RateTablesDefinitionRepository rateTablesDefinitionRepository;

	@Override
	protected RateTablesDefinition create(RateTablesDefinition rateTablesDefinition) {
		return save(rateTablesDefinition);
	}

	@Override
	protected RateTablesDefinition update(RateTablesDefinition _rateTables) {
//		return update(rateTables);
		RateTablesDefinition rateTablesDefinition = getById(_rateTables.getId());
		if(rateTablesDefinition != null)
			return save(_rateTables);
		else {
			throw new ResourceNotFoundException("RateTablesDefinition Id Doesn't Exists !");
		}
	}

	@Override
	protected RateTablesDefinition delete(RateTablesDefinition rateTablesDefinition) {
		return delete(rateTablesDefinition);
	}

	@Override
	protected List<RateTablesDefinition> search(RateTablesDefinition rateTablesDefinition) {
		return this.search(rateTablesDefinition);
	}

	@Override
	protected AbstractJpaRepository<RateTablesDefinition, Long> getRepository() {
		return this.rateTablesDefinitionRepository;
	}

	public RateTablesDefinition getById(Long id) {
		return rateTablesDefinitionRepository.getById(id);
	}

}
