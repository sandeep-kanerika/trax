package com.trax.ratemanager.rateset;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RateSetRepository extends /* AbstractJpaRepository<RateSet, String> */ JpaRepository<RateSet, String> {

	RateSet getById(String id);

	@Query("select rs from RateSet rs JOIN RateTable rt ON rs.id = :rateSetId JOIN RateColumn rc ON rt.id = :tableId")
	RateSet getByIdAndTableId(@Param("rateSetId") String rateSetId , @Param("tableId") String tableId );

}
