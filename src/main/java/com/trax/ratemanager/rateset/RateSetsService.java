package com.trax.ratemanager.rateset;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;
import com.trax.ratemaneger.utility.CreateByUserRepository;
import com.trax.ratemaneger.utility.CreatedByUser;
import com.trax.ratemaneger.utility.LastModifiedByUser;
import com.trax.ratemaneger.utility.LastModifiedByUserRepository;

@Service
public class RateSetsService extends AbstractJpaService<RateSets> {

	@Autowired
	private RateSetsRepository rateSetsRepository;
	
	@Autowired
	private LastModifiedByUserRepository lastModifiedByRepo;
	
	@Autowired
	private CreateByUserRepository createdByRepo;
	

	@Override
	protected RateSets create(RateSets rateSets) {
		LastModifiedByUser lastModifiedBy = rateSets.getLastUpdatedBy();
		CreatedByUser createdBy = rateSets.getCreatedBy();
		
		createdByRepo.save(createdBy);
		lastModifiedByRepo.save(lastModifiedBy);

		return save(rateSets);
	}

	@Override
	protected RateSets update(RateSets _rateSets) {
		RateSets rateSets = getById(_rateSets.getId());
		if (rateSets != null)
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
