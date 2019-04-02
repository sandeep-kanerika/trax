package com.trax.ratemanager.raterow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;

@Service
public class RateRowService extends AbstractJpaService<RateRow>
{

	@Autowired
	RateRowRepository rateRowsRepository;

	@Override
	public RateRow create(RateRow rateRows)
	{

		return save(rateRows);
	}

	@Override
	public RateRow update(RateRow _rateRows)
	{
		RateRow rateRows = getById(_rateRows.getId());
		if (rateRows != null) return save(_rateRows);
		else
		{
			throw new ResourceNotFoundException("RateRows Id Doesn't Exists !");
		}
	}

	@Override
	public RateRow delete(RateRow rateRows)
	{
		rateRowsRepository.delete(rateRows);
		return rateRows;
	}

	public void delete(String id)
	{
		rateRowsRepository.deleteById(id);
	}

	@Override
	public List<RateRow> search(RateRow rateRows)
	{
		return rateRowsRepository.findAll();
	}

	@Override
	public AbstractJpaRepository<RateRow, String> getRepository()
	{
		return rateRowsRepository;
	}

	public RateRow getById(String id)
	{
		return rateRowsRepository.getById(id);
	}

}
