package com.kanerika.product.ratemanager.rateset;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanerika.product.ratemanager.exception.ResourceNotFoundException;
import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;
import com.kanerika.product.ratemanager.jpa.AbstractJpaService;

@Service
public class RateSetsService extends AbstractJpaService<RateSets>{

	@Autowired
	RateSetsRepository rateSetsRepository; 
	
	@Override
	protected RateSets create(RateSets rateSets) {
		// TODO Auto-generated method stub
		return save(rateSets);
	}

	@Override
	protected RateSets update(RateSets _rateSets) {
		// TODO Auto-generated method stub
		RateSets rateSets = getById(_rateSets.getId());
		if(rateSets != null)
			return save(_rateSets);
		else {
			throw new ResourceNotFoundException("RateSets Id Doesn't Exists !");
		}
	}

	@Override
	protected RateSets delete(RateSets rateSets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<RateSets> search(RateSets rateSets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AbstractJpaRepository<RateSets, String> getRepository() {
		// TODO Auto-generated method stub
		return rateSetsRepository;
	}

	public RateSets getById(String id) {
		// TODO Auto-generated method stub
		return rateSetsRepository.getById(id);
	}

}
