package com.kanerika.product.ratemanager.raterow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanerika.product.ratemanager.exception.ResourceNotFoundException;
import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;
import com.kanerika.product.ratemanager.jpa.AbstractJpaService;

@Service
public class RateRowsService extends AbstractJpaService<RateRows>{

	@Autowired
	RateRowsRepository rateRowsRepository; 
	
	@Override
	protected RateRows create(RateRows rateRows) {
		return save(rateRows);
	}

	@Override
	protected RateRows update(RateRows _rateRows) {
		RateRows rateRows = getById(_rateRows.getId());
		if(rateRows != null)
			return save(_rateRows);
		else {
			throw new ResourceNotFoundException("RateRows Id Doesn't Exists !");
		}
	}

	@Override
	protected RateRows delete(RateRows rateRows) {
		return null;
	}

	@Override
	protected List<RateRows> search(RateRows rateRows) {
		return null;
	}

	@Override
	protected AbstractJpaRepository<RateRows, Long> getRepository() {
		return rateRowsRepository;
	}

	public RateRows getById(Long id) {
		return rateRowsRepository.getById(id);
	}

}
