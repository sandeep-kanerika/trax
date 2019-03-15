package com.trax.ratemanager.rateset;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateSetRepository extends /*AbstractJpaRepository<RateSet, String>*/ JpaRepository<RateSet, String> {
	
	RateSet getById(String id);

}
