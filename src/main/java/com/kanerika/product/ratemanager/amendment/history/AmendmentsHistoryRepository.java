package com.kanerika.product.ratemanager.amendment.history;

import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;

/**
 * Created by sudhakar.rao on 2/19/2019.
 */
public interface AmendmentsHistoryRepository extends AbstractJpaRepository<AmendmentsHistory, String> {
    AmendmentsHistory getById(String id);
}
