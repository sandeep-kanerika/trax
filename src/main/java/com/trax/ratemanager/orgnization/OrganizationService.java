package com.trax.ratemanager.orgnization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;

@Service
public class OrganizationService extends AbstractJpaService<Organization>
{

	@Autowired
	OrganizationRepository organizationRepository;

	@Override
	public Organization create(Organization orgnization)
	{
		return save(orgnization);
	}

	@Override
	public Organization update(Organization _orgnization)
	{
		Organization orgnization = getById(_orgnization.getId());
		if (orgnization != null) return save(_orgnization);
		else
		{
			throw new ResourceNotFoundException("Orgnization Id Doesn't Exists !");
		}
	}

	@Override
	public Organization delete(Organization orgnization)
	{
		organizationRepository.delete(orgnization);
		return orgnization;
	}

	public void delete(String id)
	{
		organizationRepository.deleteById(id);
	}

	@Override
	public List<Organization> search(Organization orgnization)
	{
		return organizationRepository.findAll();
	}

	@Override
	public AbstractJpaRepository<Organization, String> getRepository()
	{
		return organizationRepository;
	}

	public Organization getById(String id)
	{
		return organizationRepository.getById(id);
	}

	public List<Organization> findAll()
	{
		return organizationRepository.findAll();
	}

}
