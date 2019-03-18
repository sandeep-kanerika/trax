package com.trax.ratemanager.rateset;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;

@Service
public class RateSetsService/* extends AbstractJpaService<RateSet> */ {

	@Autowired
	private RateSetRepository rateSetsRepository;

	protected RateSet create(RateSet rateSet) {
		System.out.println("trying to store rateSets:::" + rateSet.getBuyerOrg().getId());
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

	protected ResponseEntity<?> delete(RateSet rateSets) {
		rateSetsRepository.delete(rateSets);
		return new ResponseEntity(HttpStatus.OK);
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
