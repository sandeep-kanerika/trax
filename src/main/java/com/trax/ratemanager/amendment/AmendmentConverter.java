package com.trax.ratemanager.amendment;

import com.trax.ratemanager.orgnization.Organization;
import com.trax.ratemanager.orgnization.OrganizationType;

public class AmendmentConverter {

	public static Amendment convertToAmendment(AmendmentVo amendmentVo) throws Exception {
		Amendment amendment = null;
		if (amendmentVo != null) {
			amendment = new Amendment();
			System.out.println("existing id:::" + amendmentVo.getId());
			
			amendment.setId(amendmentVo.getId());
			
			amendment.setBuyerOrg(new Organization(amendmentVo.getBuyerOrgId(), amendmentVo.getBuyerOrgName(), OrganizationType.BUYER));
			amendment.setStatus(Integer.parseInt(amendmentVo.getStatus()));
			amendment.setSellerOrg(new Organization(amendmentVo.getSellerOrgId(), amendmentVo.getSellerOrgName(), OrganizationType.SELLER));

			//			amendment.setRatesetId(amendmentVo.getRatesetId());
			
			amendment.setDescription(amendmentVo.getDescription());
			amendment.setLastUpdatedBy(amendmentVo.getLastUpdatedBy());
			amendment.setRatesetReferenceId(amendmentVo.getRatesetReferenceId());
			amendment.setReferenceId(amendmentVo.getReferenceId());
			amendment.setReviewedBy(amendmentVo.getReviewedBy());
			amendment.setType(Integer.parseInt(amendmentVo.getType()));
			amendment.setRatesetName(amendmentVo.getRatesetName());
			amendment.setRegion(amendmentVo.getRegion());
			amendment.setMode(amendmentVo.getMode());
			
			amendment.setRateRows(amendmentVo.getRateRows());
			amendment.setLastAssignedBy(amendmentVo.getLastAssignedBy());
			amendment.setApprovers(amendmentVo.getApprovers());
			amendment.setCurrentApprover(amendmentVo.getCurrentApprover());
			amendment.setDateApproved(amendmentVo.getDateApproved());
			
			amendment.setCreatedBy(amendmentVo.getCreatedBy());
			amendment.setDateCreated(amendmentVo.getDateCreated());
			amendment.setDateUpdated(amendmentVo.getDateUpdated());
			amendment.setDefaultEffectiveDateFrom(amendmentVo.getDefaultEffectiveDateFrom());
			amendment.setDefaultEffectiveDateThru(amendmentVo.getDefaultEffectiveDateThru());
			amendment.setDateReviewed(amendmentVo.getDateReviewed());
			amendment.setDateAssigned(amendmentVo.getDateAssigned());

			return amendment;

		}
		else 
		{
			throw new Exception("Problem with input");
		}

	}

	public static AmendmentVo convertToRateSetVo(Amendment amendment) 
	{
		String id = amendment.getId();
		AmendmentVo amendmentVo = new AmendmentVo();
		amendmentVo.setId(id);
		return amendmentVo;
	}

}