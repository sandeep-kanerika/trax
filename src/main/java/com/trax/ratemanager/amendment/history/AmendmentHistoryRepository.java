package com.trax.ratemanager.amendment.history;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

/**
 * Created by sudhakar.rao on 2/19/2019.
 */
public interface AmendmentsHistoryRepository extends AbstractJpaRepository<AmendmentHistory, String> {
    AmendmentHistory getById(String id);
}
