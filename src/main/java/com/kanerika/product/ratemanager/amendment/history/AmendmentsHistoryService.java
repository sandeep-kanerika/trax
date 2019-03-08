package com.kanerika.product.ratemanager.amendment.history;

import com.kanerika.product.ratemanager.exception.ResourceNotFoundException;
import com.kanerika.product.ratemanager.jpa.AbstractJpaRepository;
import com.kanerika.product.ratemanager.jpa.AbstractJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sudhakar.rao on 2/19/2019.
 */
@Service
public class AmendmentsHistoryService extends AbstractJpaService<AmendmentsHistory > {

    @Autowired
    AmendmentsHistoryRepository amendamendmentsHistoryRepository;

    @Override
    protected AmendmentsHistory create(AmendmentsHistory amendmentsHistory ) {
        return save(amendmentsHistory );
    }

    public AmendmentsHistory getById(String id) {
//		return search(id);
    	return amendamendmentsHistoryRepository.getById(id);
    }

    @Override
    protected AmendmentsHistory update(AmendmentsHistory  _amendmentsHistory ) {
        //Get the data from DB and update the fields and information from request data
		
		  AmendmentsHistory amendmentsHistory = amendamendmentsHistoryRepository.getById(_amendmentsHistory .getId());
		  if (amendmentsHistory != null) {
	        	
	        	amendmentsHistory.setStatus(_amendmentsHistory.getStatus());
	        	amendmentsHistory.setAmendmentId(_amendmentsHistory.getAmendmentId());
	        	amendmentsHistory.setActionType(_amendmentsHistory.getActionType());
	        	amendmentsHistory.setReferenceId(_amendmentsHistory.getReferenceId());
	        	amendmentsHistory.setType(_amendmentsHistory.getType());
	        	amendmentsHistory.setDescription(_amendmentsHistory.getDescription());
	        	amendmentsHistory.setRatesetId(_amendmentsHistory.getRatesetId());
	        	amendmentsHistory.setRatesetReferenceId(_amendmentsHistory.getRatesetReferenceId());
	            amendmentsHistory.setBuyerOrgId(_amendmentsHistory.getBuyerOrgId());
	            amendmentsHistory.setSellerOrgId(_amendmentsHistory.getSellerOrgId());
	            amendmentsHistory.setBuyerOrgName(_amendmentsHistory.getBuyerOrgName());
	            amendmentsHistory.setSellerOrgName(_amendmentsHistory.getSellerOrgName());
	            amendmentsHistory.setRatesetName(_amendmentsHistory.getRatesetName());
	            amendmentsHistory.setRegion(_amendmentsHistory.getRegion());
	            amendmentsHistory.setMode(_amendmentsHistory.getMode());
	            amendmentsHistory.setDefaultEffectiveDateFrom(_amendmentsHistory.getDefaultEffectiveDateFrom());
	            amendmentsHistory.setDefaultEffectiveDateThru(_amendmentsHistory.getDefaultEffectiveDateThru());
	            amendmentsHistory.setReviewedBy(_amendmentsHistory.getReviewedBy());
	            amendmentsHistory.setCreatedBy(_amendmentsHistory.getCreatedBy());
	            amendmentsHistory.setLastUpdatedBy(_amendmentsHistory.getLastUpdatedBy());
	            amendmentsHistory.setLastAssignedBy(_amendmentsHistory.getLastAssignedBy());
	            amendmentsHistory.setApprovers(_amendmentsHistory.getApprovers());
	            amendmentsHistory.setCurrentApprover(_amendmentsHistory.getCurrentApprover());
	            amendmentsHistory.setDateApproved(_amendmentsHistory.getDateApproved());
	            amendmentsHistory.setDateCreated(_amendmentsHistory.getDateCreated());
	            amendmentsHistory.setDateRecorded(_amendmentsHistory.getDateRecorded());
	            amendmentsHistory.setDateUpdated(_amendmentsHistory.getDateUpdated());
	            amendmentsHistory.setDateReviewed(_amendmentsHistory.getDateReviewed());
	            amendmentsHistory.setDateAssigned(_amendmentsHistory.getDateAssigned());
	            
	            return save(amendmentsHistory);
	        } else {
	            throw new ResourceNotFoundException("amendmentsHistory Doesn't Exists !");
	        }
    }

    @Override
    protected AmendmentsHistory delete(AmendmentsHistory amendmentsHistory ) {
        return save(amendmentsHistory);
    }

    @Override
    protected List<AmendmentsHistory > search(AmendmentsHistory amendmentsHistory ) {
        return null;
    }

    @Override
    protected AbstractJpaRepository<AmendmentsHistory , String> getRepository() {
		return amendamendmentsHistoryRepository;
    }
}
