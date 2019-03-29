package com.trax.ratemanager.raterow.history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;

@Service
public class RateRowHistoryService extends AbstractJpaService<RateRowHistory>
{

	@Autowired
	RateRowHistoryRepository rateRowsHistoryRepository;

	@Override
	public RateRowHistory create(RateRowHistory rateRowsHistory)
	{
		// TODO Auto-generated method stub
		return save(rateRowsHistory);
	}

	@Override
	public RateRowHistory update(RateRowHistory _rateRowsHistory)
	{
		// TODO Auto-generated method stub
		RateRowHistory rateRowsHistory = getById(_rateRowsHistory.getId());
		if (rateRowsHistory != null) return save(_rateRowsHistory);
		else
		{
			throw new ResourceNotFoundException("RateRowsHistory Id Doesn't Exists !");
		}
	}

	@Override
	public RateRowHistory delete(RateRowHistory rateRowsHistory)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RateRowHistory> search(RateRowHistory rateRowsHistory)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public RateRowHistory getById(String id)
	{
		// TODO Auto-generated method stub
		return rateRowsHistoryRepository.getById(id);
	}

	@Override
	public AbstractJpaRepository<RateRowHistory, String> getRepository()
	{
		return rateRowsHistoryRepository;
	}

}
