package com.trax.ratemanager.raterow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;

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
		rateRowsRepository.delete(rateRows);
		return rateRows;
	}
	
	protected void delete(String id) {
		rateRowsRepository.deleteById(id); 
	}


	@Override
	protected List<RateRows> search(RateRows rateRows) {
		return rateRowsRepository.findAll();
	}

	@Override
	protected AbstractJpaRepository<RateRows, String> getRepository() {
		return rateRowsRepository;
	}

	public RateRows getById(String id) {
		return rateRowsRepository.getById(id);
	}

}
