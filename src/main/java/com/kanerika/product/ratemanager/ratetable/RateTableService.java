package com.kanerika.product.ratemanager.ratetable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;
import com.kanerika.product.ratemanager.jpa.AbstractJpaService;

import jdk.nashorn.internal.runtime.FindProperty;

@Repository
public class RateTableService extends AbstractJpaService<RateTable> {

	@Autowired
	RateTableRepository rateTablesRepository;

	@Override
	protected RateTable create(RateTable t) {
		return save(t);
	}

	@Override
	protected RateTable update(RateTable t) {
		return update(t);
	}

	@Override
	protected RateTable delete(RateTable t) {
		return delete(t);
	}

	@Override
	protected List<RateTable> search(RateTable t) {
		return this.search(t);
	}

	@Override
	protected AbstractJpaRepository<RateTable, Long> getRepository() {
		return this.rateTablesRepository;
	}

	public RateTable getById(Long id) {
		return getById(id);
	}

}
