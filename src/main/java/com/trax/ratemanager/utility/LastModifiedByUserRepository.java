package com.trax.ratemanager.utility;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LastModifiedByUserRepository extends JpaRepository<LastModifiedByUser, String> {

}