package com.trax.ratemanager.rateset;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface RateSetRepository extends AbstractJpaRepository<RateSet,String>
{

	RateSet getById(String id);

	@Query("select rs from RateSet rs JOIN RateTable rt ON rs.id = :rateSetId JOIN RateColumn rc ON rt.id = :tableId")
	RateSet getByIdAndTableId(@Param("rateSetId") String rateSetId, @Param("tableId") String tableId);

	//@Query("select rs from RateSet rs JOIN RateTable rt ON rs.id = :rateSetId JOIN RateColumn rc ON rt.id = :tableId")
	//RateSet customRateFinder( String status, String name, String pageToken, String sortBy, String limit);

	@Override
	default Optional<RateSet> findOne(Specification<RateSet> spec) {
		return null;
	}

	@Override
	default List<RateSet> findAll(Specification<RateSet> spec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Page<RateSet> findAll(Specification<RateSet> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default long count(Specification<RateSet> spec) {
		// TODO Auto-generated method stub
		return 0;
	}

}
