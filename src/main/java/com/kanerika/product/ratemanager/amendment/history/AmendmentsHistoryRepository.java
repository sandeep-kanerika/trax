package com.kanerika.product.ratemanager.amendment.history;

import java.math.BigInteger;

import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;

/**
 * Created by sudhakar.rao on 2/19/2019.
 */
public interface AmendmentsHistoryRepository extends AbstractJpaRepository<AmendmentsHistory, Long> {
    AmendmentsHistory getById(Long id);
}
