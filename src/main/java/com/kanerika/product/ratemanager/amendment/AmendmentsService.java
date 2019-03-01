package com.kanerika.product.ratemanager.amendment;

import com.kanerika.product.ratemanager.exception.ResourceNotFoundException;
import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;
import com.kanerika.product.ratemanager.jpa.AbstractJpaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

/**
 * Created by sudhakar.rao on 2/19/2019.
 */
@Service
public class AmendmentsService extends AbstractJpaService<Amendments> {

	private static final Logger logger = LoggerFactory.getLogger(AmendmentsService.class);
	
    @Autowired
    AmendmentsRepository amendmentsRepository;

    @Override
	public Amendments create(Amendments amendments) {
        return save(amendments);
    }

    @Override
    @Transactional
	public Amendments update(Amendments _amendments) {
        //Get the data from DB and update the fields and information from request data
        Amendments amendments = getById(_amendments.getId());
        if (amendments != null) {
        	
        	amendments.setStatus(_amendments.getStatus());
        	amendments.setReferenceId(_amendments.getReferenceId());
        	amendments.setType(_amendments.getType());
        	amendments.setDescription(_amendments.getDescription());
        	amendments.setRatesetId(_amendments.getRatesetId());
        	amendments.setRatesetReferenceId(_amendments.getRatesetReferenceId());
            amendments.setBuyerOrgId(_amendments.getBuyerOrgId());
            amendments.setSellerOrgId(_amendments.getSellerOrgId());
            amendments.setBuyerOrgName(_amendments.getBuyerOrgName());
            amendments.setSellerOrgName(_amendments.getSellerOrgName());
            amendments.setRatesetName(_amendments.getRatesetName());
            amendments.setRegion(_amendments.getRegion());
            amendments.setMode(_amendments.getMode());
            amendments.setDefaultEffectiveDateFrom(_amendments.getDefaultEffectiveDateFrom());
            amendments.setDefaultEffectiveDateThru(_amendments.getDefaultEffectiveDateThru());
            amendments.setReviewedBy(_amendments.getReviewedBy());
            amendments.setCreatedBy(_amendments.getCreatedBy());
            amendments.setLastUpdatedBy(_amendments.getLastUpdatedBy());
            amendments.setLastAssignedBy(_amendments.getLastAssignedBy());
            amendments.setApprovers(_amendments.getApprovers());
            amendments.setCurrentApprover(_amendments.getCurrentApprover());
            amendments.setDateApproved(_amendments.getDateApproved());
            amendments.setDateCreated(_amendments.getDateCreated());
            amendments.setDateUpdated(_amendments.getDateUpdated());
            amendments.setDateReviewed(_amendments.getDateReviewed());
            amendments.setDateAssigned(_amendments.getDateAssigned());
            
            return save(amendments);
        } else {
            throw new ResourceNotFoundException("Amendment Id Not Found !");
        }
    }

    public Amendments getById(Long id) {
//		return search(id);
    	return amendmentsRepository.getById(id);
    }

    @Override
    @Transactional
    protected Amendments delete(Amendments amendments) {
        return save(amendments);
    }

    @Override
    protected List<Amendments> search(Amendments amendments) {
        return null;
    }

    @Override
    protected AbstractJpaRepository<Amendments, Long> getRepository() {
		return amendmentsRepository ;
    }
}
