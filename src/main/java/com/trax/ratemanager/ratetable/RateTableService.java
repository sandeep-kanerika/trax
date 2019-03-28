package com.trax.ratemanager.ratetable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;

@Repository
public class RateTableService extends AbstractJpaService<RateTable> {

	@Autowired
	RateTableRepository rateTableRepository;

	@Override
	public RateTable create(RateTable rateTable) {
		return save(rateTable);
	}

	@Override
	public RateTable update(RateTable _rateTables) {
//		return update(rateTables);
		RateTable rateTablesDefinition = getById(_rateTables.getId());
		if (rateTablesDefinition != null)
			return save(_rateTables);
		else {
			throw new ResourceNotFoundException("RateTable Id Doesn't Exists !");
		}
	}

	@Override
	public RateTable delete(RateTable rateTable) {
		return delete(rateTable);
	}

	@Override
	public List<RateTable> search(RateTable rateTable) {
		return this.search(rateTable);
	}

	@Override
	public AbstractJpaRepository<RateTable, String> getRepository() {
		return this.rateTableRepository;
	}

	public RateTable getById(String id) {
		return rateTableRepository.getById(id);
	}

}
