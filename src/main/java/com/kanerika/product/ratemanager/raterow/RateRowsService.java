package com.kanerika.product.ratemanager.raterow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;
import com.kanerika.product.ratemanager.jpa.AbstractJpaService;

@Repository
public class RateRowsService extends AbstractJpaService<RateRows>{

	@Autowired
	RateRowsRepository rateRowsRepository; 
	
	@Override
	protected RateRows create(RateRows rateRows) {
		// TODO Auto-generated method stub
		return save(rateRows);
	}

	@Override
	protected RateRows update(RateRows _rateRows) {
		// TODO Auto-generated method stub
		return save(_rateRows);
	}

	@Override
	protected RateRows delete(RateRows rateRows) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<RateRows> search(RateRows rateRows) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AbstractJpaRepository<RateRows, Long> getRepository() {
		// TODO Auto-generated method stub
		return rateRowsRepository;
	}

	public RateRows getById(Long id) {
		// TODO Auto-generated method stub
		return rateRowsRepository.getById(id);
	}

}
