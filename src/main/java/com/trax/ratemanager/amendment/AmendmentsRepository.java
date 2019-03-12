package com.trax.ratemanager.amendment;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

/**
 * Created by sudhakar.rao on 2/19/2019.
 */
@Repository
public interface AmendmentsRepository extends AbstractJpaRepository<Amendments, String> {
	
    Amendments getById(String id);
    
    @Query("SELECT u FROM Amendments u WHERE u.status = 1")
    Collection<Amendments> findAllActiveAmendments();
    
}
