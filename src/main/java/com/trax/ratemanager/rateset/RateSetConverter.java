package com.trax.ratemanager.rateset;

import com.trax.ratemanager.orgnization.OrganizationType;
import com.trax.ratemanager.orgnization.Orgnization;

public class RateSetConverter {

	public static RateSet convertToRateSet(RateSetVo rateSetVo) throws Exception {
		RateSet rateSet = null;
		if (rateSetVo != null) {
			rateSet = new RateSet();
			System.out.println("existing id:::" + rateSetVo.getId());

			rateSet.setId(rateSetVo.getId());
			rateSet.setApprovers(rateSetVo.getApprovers());
			rateSet.setDateCreated(rateSetVo.getDateCreated());
			rateSet.setDateUpdated(rateSetVo.getDateUpdated());
			rateSet.setMode(rateSetVo.getMode());
			rateSet.setName(rateSetVo.getName());
			rateSet.setStatus(Integer.parseInt(rateSetVo.getStatus()));
			rateSet.setRegion(rateSetVo.getRegion());
			rateSet.setTableHash(rateSetVo.getTableHash());
			rateSet.setTables(rateSetVo.getTables());

			rateSet.setBuyerOrg(new Orgnization(rateSetVo.getBuyerOrgId(), rateSetVo.getBuyerOrgName(), OrganizationType.BUYER));
			rateSet.setSellerOrg(new Orgnization(rateSetVo.getSellerOrgId(), rateSetVo.getSellerOrgName(), OrganizationType.SELLER));

			return rateSet;

		}
		else 
		{
			throw new Exception("Problem with input");
		}

	}

	public static RateSetVo convertToRateSetVo(RateSet rateSet) {
		return new RateSetVo();
	}

}