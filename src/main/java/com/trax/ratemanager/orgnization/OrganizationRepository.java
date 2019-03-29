package com.trax.ratemanager.orgnization;

import org.springframework.stereotype.Repository;

import com.trax.ratemanager.jpa.AbstractJpaRepository;

@Repository
public interface OrganizationRepository extends AbstractJpaRepository<Organization, String>
{

	Organization getById(String id);

}
