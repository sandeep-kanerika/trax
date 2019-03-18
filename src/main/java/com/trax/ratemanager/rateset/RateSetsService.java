package com.trax.ratemanager.rateset;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;

@Service
public class RateSetsService/* extends AbstractJpaService<RateSet> */ {

	@Autowired
	private RateSetRepository rateSetsRepository;

	protected RateSet create(RateSet rateSet) {
		System.out.println("trying to store rateSets:::");
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
		rateSetsRepository.delete(rateSets);
		return rateSets;
	}

	public List<RateSet> search(RateSet rateSets) {
		return rateSetsRepository.findAll();
	}

	public RateSet getById(String id) {
		return rateSetsRepository.getById(id);
	}

	public List<RateSet> findAll() {
		return rateSetsRepository.findAll();
	}

}
