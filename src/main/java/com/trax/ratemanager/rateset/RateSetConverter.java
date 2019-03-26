package com.trax.ratemanager.rateset;

import java.util.ArrayList;
import java.util.List;

import com.trax.ratemanager.orgnization.Organization;
import com.trax.ratemanager.orgnization.OrganizationType;
import com.trax.ratemanager.ratecolumn.RateColumn;
import com.trax.ratemanager.ratetable.RateTable;
import com.trax.ratemanager.ratetable.RateTableConverter;
import com.trax.ratemanager.ratetable.RateTableVo;

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
			rateSet.setDateReviewed(rateSetVo.getDateReviewed());
			rateSet.setDateAssigned(rateSetVo.getDateAssigned());
			rateSet.setEffectiveDateFrom(rateSetVo.getEffectiveDateFrom());
			rateSet.setEffectiveDateThru(rateSetVo.getEffectiveDateThru());
			
			rateSet.setMode(rateSetVo.getMode());
			rateSet.setName(rateSetVo.getName());
			rateSet.setStatus(Integer.parseInt(rateSetVo.getStatus()));
			rateSet.setRegion(rateSetVo.getRegion());
			rateSet.setTableHash(rateSetVo.getTableHash());
			
			List<RateTableVo> rateTableVos = rateSetVo.getTables();
			
			List<RateTable> rateTables = new ArrayList<RateTable>();
			for (RateTableVo rateTableVo : rateTableVos) {
				RateTable table =  RateTableConverter.convertToRateTable(rateTableVo);
				System.out.println("---table---" + table);
				table.setRateSetId(rateSet.getId());
				rateTables.add(table);
			}
			rateSet.setTables(rateTables);
			
			rateSet.setCreatedBy(rateSetVo.getCreatedBy());
			rateSet.setLastUpdatedBy(rateSetVo.getLastUpdatedBy());
			rateSet.setReviewedBy(rateSetVo.getReviewedBy());
			rateSet.setLastAssignedBy(rateSetVo.getLastAssignedBy());
			rateSet.setApprovers(rateSetVo.getApprovers());
			
			rateSet.setBuyerOrg(new Organization(rateSetVo.getBuyerOrgId(), rateSetVo.getBuyerOrgName(), OrganizationType.BUYER));
			rateSet.setSellerOrg(new Organization(rateSetVo.getSellerOrgId(), rateSetVo.getSellerOrgName(), OrganizationType.SELLER));

			return rateSet;

		}
		else 
		{
			throw new Exception("Problem with input");
		}

	}

	public static RateSetVo convertToRateSetVo(RateSet rateSet) 
	{
		String id = rateSet.getId();
		 RateSetVo rateSetVo = new RateSetVo();
		 rateSetVo.setId(id);
		return rateSetVo;
	}

}