package com.trax.ratemanager.rateset.definition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;

@Service
public class RateSetDefinitionService extends AbstractJpaService<RateSetDefinition> {

	@Autowired
	RateSetDefinitionRepository rateSetsDefinitionRepository; 
	
	@Override
	protected RateSetDefinition create(RateSetDefinition rateSetsDefinition) {
		return save(rateSetsDefinition);
	}

	@Override
	protected RateSetDefinition update(RateSetDefinition _rateSetsDefinition) {
		RateSetDefinition rateSetsDefinition = getById(_rateSetsDefinition.getId());
		if(rateSetsDefinition != null)
			return save(_rateSetsDefinition);
		else {
			throw new ResourceNotFoundException("RateSetsDefinition Id Doesn't Exists !");
		}
	}

	@Override
	protected RateSetDefinition delete(RateSetDefinition rateSetsDefinition) {
		rateSetsDefinitionRepository.delete(rateSetsDefinition);
		return rateSetsDefinition;
	}

	@Override
	protected List<RateSetDefinition> search(RateSetDefinition rateSetsDefinition) {
		return null;
	}

	@Override
	protected AbstractJpaRepository<RateSetDefinition, String> getRepository() {
		return rateSetsDefinitionRepository;
	}

	public RateSetDefinition getById(String id) {
		return rateSetsDefinitionRepository.getById(id);
	}
	
	public List<RateSetDefinition> findAll() {
		return rateSetsDefinitionRepository.findAll();
	}
	
}
