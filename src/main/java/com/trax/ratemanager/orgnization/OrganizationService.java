package com.trax.ratemanager.orgnization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;

@Service
public class OrganizationService extends AbstractJpaService<Orgnization>{

	@Autowired
	OrganizationRepository organizationRepository; 
	
	@Override
	protected Orgnization create(Orgnization orgnization) {
		return save(orgnization);
	}

	@Override
	protected Orgnization update(Orgnization _orgnization) {
		Orgnization orgnization = getById(_orgnization.getId());
		if(orgnization != null)
			return save(_orgnization);
		else {
			throw new ResourceNotFoundException("Orgnization Id Doesn't Exists !");
		}
	}

	@Override
	protected Orgnization delete(Orgnization orgnization) {
		organizationRepository.delete(orgnization);
		return orgnization;
	}
	
	protected void delete(String id) {
		organizationRepository.deleteById(id); 
	}


	@Override
	protected List<Orgnization> search(Orgnization orgnization) {
		return organizationRepository.findAll();
	}

	@Override
	protected AbstractJpaRepository<Orgnization, String> getRepository() {
		return organizationRepository;
	}

	public Orgnization getById(String id) {
		return organizationRepository.getById(id);
	}

}
