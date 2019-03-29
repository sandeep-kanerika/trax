package com.trax.ratemanager.amendment.history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.jpa.AbstractJpaRepository;
import com.trax.ratemanager.jpa.AbstractJpaService;

/**
 * Created by sudhakar.rao on 2/19/2019.
 */
@Service
public class AmendmentHistoryService extends AbstractJpaService<AmendmentHistory>
{

	@Autowired
	AmendmentHistoryRepository amendmentsHistoryRepository;

	@Override
	public AmendmentHistory create(AmendmentHistory amendmentsHistory)
	{
		return save(amendmentsHistory);
	}

	public AmendmentHistory getById(String id)
	{
		// return search(id);
		return amendmentsHistoryRepository.getById(id);
	}

	@Override
	public AmendmentHistory update(AmendmentHistory _amendmentsHistory)
	{
		// Get the data from DB and update the fields and information from
		// request data

		AmendmentHistory amendmentsHistory = amendmentsHistoryRepository.getById(_amendmentsHistory.getId());
		if (amendmentsHistory != null)
		{

			amendmentsHistory.setStatus(_amendmentsHistory.getStatus());
			amendmentsHistory.setAmendmentId(_amendmentsHistory.getAmendmentId());
			amendmentsHistory.setActionType(_amendmentsHistory.getActionType());
			amendmentsHistory.setReferenceId(_amendmentsHistory.getReferenceId());
			amendmentsHistory.setType(_amendmentsHistory.getType());
			amendmentsHistory.setDescription(_amendmentsHistory.getDescription());
			amendmentsHistory.setRatesetId(_amendmentsHistory.getRatesetId());
			amendmentsHistory.setRatesetReferenceId(_amendmentsHistory.getRatesetReferenceId());
			/*
			 * amendmentsHistory.setBuyerOrgId(_amendmentsHistory.getBuyerOrgId(
			 * )); amendmentsHistory.setSellerOrgId(_amendmentsHistory.
			 * getSellerOrgId());
			 * amendmentsHistory.setBuyerOrgName(_amendmentsHistory.
			 * getBuyerOrgName());
			 * amendmentsHistory.setSellerOrgName(_amendmentsHistory.
			 * getSellerOrgName());
			 */
			amendmentsHistory.setBuyerOrg(_amendmentsHistory.getBuyerOrg());
			amendmentsHistory.setSellerOrg(_amendmentsHistory.getSellerOrg());
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
		}
		else
		{
			throw new ResourceNotFoundException("amendmentsHistory Doesn't Exists !");
		}
	}

	@Override
	public AmendmentHistory delete(AmendmentHistory amendmentsHistory)
	{
		amendmentsHistoryRepository.delete(amendmentsHistory);
		return amendmentsHistory;
	}

	@Override
	public List<AmendmentHistory> search(AmendmentHistory amendmentsHistory)
	{
		return amendmentsHistoryRepository.findAll();
	}

	@Override
	public AbstractJpaRepository<AmendmentHistory, String> getRepository()
	{
		return amendmentsHistoryRepository;
	}
}
