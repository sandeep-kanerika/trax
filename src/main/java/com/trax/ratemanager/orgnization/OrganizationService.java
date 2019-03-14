package com.trax.ratemanager.orgnization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;

@Service
public class OrganizationService extends AbstractJpaService<Organization> {

	@Autowired
	OrganizationRepository organizationRepository;

	@Override
	protected Organization create(Organization orgnization) {
		return save(orgnization);
	}

	@Override
	protected Organization update(Organization org) {
		Organization orgnization = getById(org.getId());
		if (orgnization != null)
			return save(org);
		else {
			throw new ResourceNotFoundException("Orgnization Id Doesn't Exists !");
		}
	}

	@Override
	protected Organization delete(Organization orgnization) {
		organizationRepository.delete(orgnization);
		return orgnization;
	}

	protected void delete(String id) {
		organizationRepository.deleteById(id);
	}

	@Override
	protected List<Organization> search(Organization orgnization) {
		return organizationRepository.findAll();
	}

	@Override
	protected AbstractJpaRepository<Organization, String> getRepository() {
		return organizationRepository;
	}

	public Organization getById(String id) {
		return organizationRepository.getById(id);
	}

}
