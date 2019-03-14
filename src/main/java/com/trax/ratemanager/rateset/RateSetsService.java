package com.trax.ratemanager.rateset;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;
import com.trax.ratemaneger.utility.UserRepository;

@Service
public class RateSetsService extends AbstractJpaService<RateSets> {

	@Autowired
	private RateSetsRepository rateSetsRepository;

	@Autowired
	private UserRepository createdByRepo;

	@Override
	protected RateSets create(RateSets rateSets) {
		/*
		 * LastModifiedByUser lastModifiedBy = rateSets.getLastUpdatedBy();
		 * CreatedByUser createdBy = rateSets.getCreatedBy();
		 * 
		 * createdByRepo.save(createdBy); lastModifiedByRepo.save(lastModifiedBy);
		 */

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
		return null;
	}

	@Override
	protected List<RateSets> search(RateSets rateSets) {
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
				.withIgnorePaths("lastUpdatedBy", "buyerOrg", "sellerOrg", "amendments", "user");
		Example<RateSets> example = Example.of(rateSets, matcher);
		return rateSetsRepository.findAll(example);
	}

	@Override
	protected AbstractJpaRepository<RateSets, String> getRepository() {
		return rateSetsRepository;
	}

	public RateSets getById(String id) {
		return rateSetsRepository.getById(id);
	}

}
