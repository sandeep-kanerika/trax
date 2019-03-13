package com.trax.ratemanager.amendment;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;
import com.trax.ratemaneger.utility.LastModifiedByUser;
import com.trax.ratemaneger.utility.LastModifiedByUserRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by sudhakar.rao on 2/19/2019.
 */
@Service
@Slf4j
public class AmendmentsService extends AbstractJpaService<Amendments> {

	private static final Logger logger = LoggerFactory.getLogger(AmendmentsService.class);

	@Autowired
	private LastModifiedByUserRepository lastModifiedByUserRepo;

	@Autowired
	private AmendmentsRepository amendmentsRepository;

	@Override
	public Amendments create(Amendments amendments) {
		log.debug("inside create ammendments");

		LastModifiedByUser lastUpdateBy = amendments.getLastUpdatedBy();
		lastModifiedByUserRepo.save(lastUpdateBy);
		return save(amendments);
	}

	@Override
	@Transactional
	public Amendments update(Amendments _amendments) {
		// Get the data from DB and update the fields and information from request data
		Amendments amendments = getById(_amendments.getId());
		if (amendments != null) {
			return save(amendments);
		} else {
			throw new ResourceNotFoundException("Amendment Id Not Found !");
		}
	}

	public Amendments getById(String id) {
		return amendmentsRepository.getById(id);
	}

	@Override
	@Transactional
	protected Amendments delete(Amendments amendments) {
		amendmentsRepository.delete(amendments);
		return amendments;
	}

	public Boolean delete(String id) {
		try {
			amendmentsRepository.deleteById(id);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	protected List<Amendments> search(Amendments amendments) {
		return amendmentsRepository.findAll();
	}

	@Override
	protected AbstractJpaRepository<Amendments, String> getRepository() {
		return amendmentsRepository;
	}
}