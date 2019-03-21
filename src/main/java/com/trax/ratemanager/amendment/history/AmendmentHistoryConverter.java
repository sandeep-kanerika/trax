package com.trax.ratemanager.amendment.history;

import com.trax.ratemanager.orgnization.Organization;
import com.trax.ratemanager.orgnization.OrganizationType;

public class AmendmentHistoryConverter {

	public static AmendmentHistory convertToAmendmentHistory(AmendmentHistoryVo amendmentHistoryVo) throws Exception {
		AmendmentHistory amendmentHistory = null;
		if (amendmentHistoryVo != null) {
			amendmentHistory = new AmendmentHistory();
			System.out.println("existing id:::" + amendmentHistoryVo.getId());

			amendmentHistory.setId(amendmentHistoryVo.getId());
			amendmentHistory.setAmendmentId(amendmentHistoryVo.getAmendmentId());
			amendmentHistory.setActionType(amendmentHistoryVo.getActionType());
			
			amendmentHistory.setBuyerOrg(new Organization(amendmentHistoryVo.getBuyerOrgId(), amendmentHistoryVo.getBuyerOrgName(),
					OrganizationType.BUYER));
			amendmentHistory.setSellerOrg(new Organization(amendmentHistoryVo.getSellerOrgId(), amendmentHistoryVo.getSellerOrgName(),
					OrganizationType.SELLER));

			amendmentHistory.setRatesetId(amendmentHistoryVo.getRatesetId());

			amendmentHistory.setDescription(amendmentHistoryVo.getDescription());
			amendmentHistory.setRatesetReferenceId(amendmentHistoryVo.getRatesetReferenceId());
			amendmentHistory.setReferenceId(amendmentHistoryVo.getReferenceId());
			amendmentHistory.setReviewedBy(amendmentHistoryVo.getReviewedBy());
			amendmentHistory.setType(Integer.parseInt(amendmentHistoryVo.getType()));
			amendmentHistory.setRatesetName(amendmentHistoryVo.getRatesetName());
			amendmentHistory.setRegion(amendmentHistoryVo.getRegion());
			amendmentHistory.setMode(amendmentHistoryVo.getMode());
			amendmentHistory.setStatus(Integer.parseInt(amendmentHistoryVo.getStatus()));

			amendmentHistory.setRateRows(amendmentHistoryVo.getRateRows());
			
			amendmentHistory.setDateRecorded(amendmentHistoryVo.getDateRecorded());
			amendmentHistory.setCreatedBy(amendmentHistoryVo.getCreatedBy());
			amendmentHistory.setDateCreated(amendmentHistoryVo.getDateCreated());
			amendmentHistory.setDateUpdated(amendmentHistoryVo.getDateUpdated());
			amendmentHistory.setDefaultEffectiveDateFrom(amendmentHistoryVo.getDefaultEffectiveDateFrom());
			amendmentHistory.setDefaultEffectiveDateThru(amendmentHistoryVo.getDefaultEffectiveDateThru());
			amendmentHistory.setDateReviewed(amendmentHistoryVo.getDateReviewed());
			amendmentHistory.setDateAssigned(amendmentHistoryVo.getDateAssigned());
			amendmentHistory.setLastUpdatedBy(amendmentHistoryVo.getLastUpdatedBy());

			amendmentHistory.setLastAssignedBy(amendmentHistoryVo.getLastAssignedBy());
			amendmentHistory.setApprovers(amendmentHistoryVo.getApprovers());
			amendmentHistory.setCurrentApprover(amendmentHistoryVo.getCurrentApprover());

			return amendmentHistory;

		} else {
			throw new Exception("Problem with input");
		}

	}

	public static AmendmentHistoryVo convertToRateSetVo(AmendmentHistory amendmentHistory) {
		String id = amendmentHistory.getId();
		AmendmentHistoryVo amendmentHistoryVo = new AmendmentHistoryVo();
		amendmentHistoryVo.setId(id);
		return amendmentHistoryVo;
	}

}