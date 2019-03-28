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
	private RateSetDefinitionRepository rateSetsDefinitionRepository; 
	
	@Override
	public RateSetDefinition create(RateSetDefinition rateSetsDefinition) {
		return save(rateSetsDefinition);
	}

	@Override
	public RateSetDefinition update(RateSetDefinition rateSetDefination) {
		System.out.println("RateSetDefinitionService.update()--->"+rateSetDefination.getId());
		RateSetDefinition rateSetsDefinition = getById(rateSetDefination.getId());
		if(rateSetsDefinition != null)
			return save(rateSetDefination);
		else {
			throw new ResourceNotFoundException("RateSetsDefinition Id Doesn't Exists !");
		}
	}

	@Override
	public RateSetDefinition delete(RateSetDefinition rateSetsDefinition) {
		rateSetsDefinitionRepository.delete(rateSetsDefinition);
		return rateSetsDefinition;
	}

	@Override
	public List<RateSetDefinition> search(RateSetDefinition rateSetsDefinition) {
		return null;
	}

	@Override
	public AbstractJpaRepository<RateSetDefinition, String> getRepository() {
		return rateSetsDefinitionRepository;
	}

	public RateSetDefinition getById(String id) {
		return rateSetsDefinitionRepository.getById(id);
	}
	
	public List<RateSetDefinition> findAll() {
		return rateSetsDefinitionRepository.findAll();
	}
	
}
