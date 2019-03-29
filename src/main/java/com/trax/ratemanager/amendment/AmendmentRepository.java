package com.trax.ratemanager.amendment;

import org.springframework.stereotype.Repository;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

/**
 * Created by sudhakar.rao on 2/19/2019.
 */
@Repository
public interface AmendmentRepository extends AbstractJpaRepository<Amendment, String>
{

	Amendment getById(String id);
	/*
	 * @Query("SELECT u FROM Amendments u WHERE u.tableId: 1 and id:id")
	 * Collection<Amendment> findAllActiveAmendments(String id, String tablId);
	 */
}
