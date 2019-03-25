package com.trax.ratemanager.ratecolumn;

import com.trax.ratemanager.orgnization.Organization;
import com.trax.ratemanager.orgnization.OrganizationType;

public class RateColumnConverter {

	public static RateColumn convertToAmendmentHistory(RateColumnVo rateColumnVo) throws Exception {
		RateColumn rateColumn = null;
		if (rateColumnVo != null) {
			rateColumn = new RateColumn();
			System.out.println("existing id:::" + rateColumnVo.getId());

			rateColumn.setId(rateColumnVo.getId());
			rateColumn.setAmendmentId(rateColumnVo.getAmendmentId());
			rateColumn.setActionType(rateColumnVo.getActionType());

			rateColumn.setBuyerOrg(new Organization(rateColumnVo.getBuyerOrgId(), rateColumnVo.getBuyerOrgName(),
					OrganizationType.BUYER));
			rateColumn.setSellerOrg(new Organization(rateColumnVo.getSellerOrgId(), rateColumnVo.getSellerOrgName(),
					OrganizationType.SELLER));

			rateColumn.setRatesetId(rateColumnVo.getRatesetId());

			rateColumn.setDescription(rateColumnVo.getDescription());
			rateColumn.setRatesetReferenceId(rateColumnVo.getRatesetReferenceId());
			rateColumn.setReferenceId(rateColumnVo.getReferenceId());
			rateColumn.setReviewedBy(rateColumnVo.getReviewedBy());
			rateColumn.setType(Integer.parseInt(rateColumnVo.getType()));
			rateColumn.setRatesetName(rateColumnVo.getRatesetName());
			rateColumn.setRegion(rateColumnVo.getRegion());
			rateColumn.setMode(rateColumnVo.getMode());
			rateColumn.setStatus(Integer.parseInt(rateColumnVo.getStatus()));

			rateColumn.setRateRows(rateColumnVo.getRateRows());

			rateColumn.setDateRecorded(rateColumnVo.getDateRecorded());
			rateColumn.setCreatedBy(rateColumnVo.getCreatedBy());
			rateColumn.setDateCreated(rateColumnVo.getDateCreated());
			rateColumn.setDateUpdated(rateColumnVo.getDateUpdated());
			rateColumn.setDefaultEffectiveDateFrom(rateColumnVo.getDefaultEffectiveDateFrom());
			rateColumn.setDefaultEffectiveDateThru(rateColumnVo.getDefaultEffectiveDateThru());
			rateColumn.setDateReviewed(rateColumnVo.getDateReviewed());
			rateColumn.setDateAssigned(rateColumnVo.getDateAssigned());
			rateColumn.setLastUpdatedBy(rateColumnVo.getLastUpdatedBy());

			rateColumn.setLastAssignedBy(rateColumnVo.getLastAssignedBy());
			rateColumn.setApprovers(rateColumnVo.getApprovers());
			rateColumn.setCurrentApprover(rateColumnVo.getCurrentApprover());

			return rateColumn;

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