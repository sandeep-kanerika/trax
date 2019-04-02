package com.trax.ratemanager.ratecolumn;

import org.springframework.stereotype.Repository;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface RateColumnRepository extends AbstractJpaRepository<RateColumn, String>
{

	RateColumn getById(String id);
}
