package com.trax.ratemanager.raterow.history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;

@Service
public class RateRowsHistoryService extends AbstractJpaService<RateRowsHistory>{

	@Autowired
	RateRowsHistoryRepository rateRowsHistoryRepository; 
	
	@Override
	protected RateRowsHistory create(RateRowsHistory rateRowsHistory) {
		// TODO Auto-generated method stub
		return save(rateRowsHistory);
	}

	@Override
	protected RateRowsHistory update(RateRowsHistory _rateRowsHistory) {
		// TODO Auto-generated method stub
		RateRowsHistory rateRowsHistory = getById(_rateRowsHistory.getId());
		if(rateRowsHistory != null)
			return save(_rateRowsHistory);
		else {
			throw new ResourceNotFoundException("RateRowsHistory Id Doesn't Exists !");
		}
	}

	@Override
	protected RateRowsHistory delete(RateRowsHistory rateRowsHistory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<RateRowsHistory> search(RateRowsHistory rateRowsHistory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AbstractJpaRepository<RateRowsHistory, String> getRepository() {
		// TODO Auto-generated method stub
		return rateRowsHistoryRepository;
	}

	public RateRowsHistory getById(String id) {
		// TODO Auto-generated method stub
		return rateRowsHistoryRepository.getById(id);
	}

}
