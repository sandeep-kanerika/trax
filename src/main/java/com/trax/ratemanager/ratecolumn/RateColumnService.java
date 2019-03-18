package com.trax.ratemanager.ratecolumn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;

@Service
public class RateColumnService extends AbstractJpaService<RateColumn>{

	@Autowired
	RateColumnRepository rateColumnRepository;
	
	@Override
	protected RateColumn create(RateColumn rateColumn) {
		return save(rateColumn);
	}

	@Override
	protected RateColumn update(RateColumn _rateColumn) {
		RateColumn RateColumn = getById(_rateColumn.getId());
        if (RateColumn != null) {
        	return save(_rateColumn);
        }else {
        	throw new ResourceNotFoundException("RateColumn Id Not Found !");
        }
	}

	@Override
	protected RateColumn delete(RateColumn rateColumn) {
		return delete(rateColumn);
		
	}

	@Override
	protected List<RateColumn> search(RateColumn rateColumn) {
		return null;
	}

	@Override
	protected AbstractJpaRepository<RateColumn, String> getRepository() {
		return rateColumnRepository;
	}

	public RateColumn getById(String id) {
		return rateColumnRepository.getById(id);
	}

}
