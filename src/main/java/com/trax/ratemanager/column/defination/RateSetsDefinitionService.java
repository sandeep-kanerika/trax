package com.trax.ratemanager.column.defination;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;
import com.trax.ratemanager.rateset.RateSet;

@Service
public class RateSetsDefinitionService extends AbstractJpaService<RateSetsDefinition> {

	@Autowired
	RateSetsDefinitionRepository rateSetsDefinitionRepository; 
	
	@Override
	protected RateSetsDefinition create(RateSetsDefinition rateSetsDefinition) {
		// TODO Auto-generated method stub
		return save(rateSetsDefinition);
	}

	@Override
	protected RateSetsDefinition update(RateSetsDefinition _rateSetsDefinition) {
		// TODO Auto-generated method stub
		RateSetsDefinition rateSetsDefinition = getById(_rateSetsDefinition.getId());
		if(rateSetsDefinition != null)
			return save(_rateSetsDefinition);
		else {
			throw new ResourceNotFoundException("RateSetsDefinition Id Doesn't Exists !");
		}
	}

	@Override
	protected RateSetsDefinition delete(RateSetsDefinition rateSetsDefinition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<RateSetsDefinition> search(RateSetsDefinition rateSetsDefinition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AbstractJpaRepository<RateSetsDefinition, String> getRepository() {
		// TODO Auto-generated method stub
		return rateSetsDefinitionRepository;
	}

	public RateSetsDefinition getById(String id) {
		// TODO Auto-generated method stub
		return rateSetsDefinitionRepository.getById(id);
	}
	
}
