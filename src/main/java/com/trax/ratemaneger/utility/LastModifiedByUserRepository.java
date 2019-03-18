
package com.trax.ratemaneger.utility;

import org.springframework.stereotype.Repository;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

/**
 * Created by Sandeep Sable
 */
@Repository
public interface LastModifiedByUserRepository extends AbstractJpaRepository<LastModifiedByUser, String> {

}
