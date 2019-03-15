package com.trax.ratemanager.rateset;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemaneger.utility.CreateByUserRepository;
import com.trax.ratemaneger.utility.CreatedByUser;
import com.trax.ratemaneger.utility.LastModifiedByUser;
import com.trax.ratemaneger.utility.LastModifiedByUserRepository;

@Service
public class RateSetsService/* extends AbstractJpaService<RateSet> */ {

	@Autowired
	private RateSetRepository rateSetsRepository;

	@Autowired
	private LastModifiedByUserRepository lastModifiedByRepo;

	@Autowired
	private CreateByUserRepository createdByRepo;

	protected RateSet create(RateSet rateSet) {
		System.out.println("RateSet:::::" + rateSet);

		LastModifiedByUser lastModifiedBy = rateSet.getLastUpdatedBy();
		CreatedByUser createdBy = rateSet.getCreatedBy();

		System.out.println("lastModifiedBy:" + lastModifiedBy);
		System.out.println("createdby:" + createdBy);

		if (createdBy != null)
			createdByRepo.save(createdBy);
		if (lastModifiedBy != null)
			lastModifiedByRepo.save(lastModifiedBy);

		System.out.println("trying to store rateSets:::" + rateSet);
		return rateSetsRepository.save(rateSet);
	}

	protected RateSet update(RateSet _rateSets) {
		Optional<RateSet> rateSet = rateSetsRepository.findById(_rateSets.getId());
		if (rateSet.isPresent())
			return rateSetsRepository.save(rateSet.get());
		else {
			throw new ResourceNotFoundException("RateSets Id Doesn't Exists !");
		}
	}

	protected RateSet delete(RateSet rateSets) {
		return null;
	}

	public List<RateSet> search(RateSet rateSets) {
		return null;
	}

	public RateSet getById(String id) {
		return rateSetsRepository.getById(id);
	}

}
