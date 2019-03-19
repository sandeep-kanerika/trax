package com.trax.ratemanager.rateset.definition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;
import com.trax.ratemanager.rateset.RateSet;

@Service
public class RateSetDefinitionService extends AbstractJpaService<RateSetDefinition> {

	@Autowired
	RateSetDefinitionRepository rateSetsDefinitionRepository; 
	
	@Override
	protected RateSetDefinition create(RateSetDefinition rateSetsDefinition) {
		// TODO Auto-generated method stub
		return save(rateSetsDefinition);
	}

	@Override
	protected RateSetDefinition update(RateSetDefinition _rateSetsDefinition) {
		// TODO Auto-generated method stub
		RateSetDefinition rateSetsDefinition = getById(_rateSetsDefinition.getId());
		if(rateSetsDefinition != null)
			return save(_rateSetsDefinition);
		else {
			throw new ResourceNotFoundException("RateSetsDefinition Id Doesn't Exists !");
		}
	}

	@Override
	protected RateSetDefinition delete(RateSetDefinition rateSetsDefinition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<RateSetDefinition> search(RateSetDefinition rateSetsDefinition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AbstractJpaRepository<RateSetDefinition, String> getRepository() {
		// TODO Auto-generated method stub
		return rateSetsDefinitionRepository;
	}

	public RateSetDefinition getById(String id) {
		// TODO Auto-generated method stub
		return rateSetsDefinitionRepository.getById(id);
	}
	
}
