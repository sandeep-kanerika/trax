package com.trax.ratemanager.rateset;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.trax.ratemanager.exception.OrganizationNotFoundException;
import com.trax.ratemanager.orgnization.Organization;
import com.trax.ratemanager.orgnization.OrganizationService;
import com.trax.ratemanager.ratetable.RateTable;
import com.trax.ratemanager.ratetable.RateTableConverter;
import com.trax.ratemanager.ratetable.RateTableVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RateSetConverter
{
	@Autowired
	private OrganizationService orgService;

	public RateSet convertToRateSet(RateSetVo rateSetVo) throws Exception
	{
		RateSet rateSet = null;
		if (rateSetVo != null)
		{
			rateSet = new RateSet();
			log.info("***************existing id in convertor ::::" + rateSetVo.getId());

			String buyerOrgId = rateSetVo.getBuyerOrgId();
			String sellerOrgId = rateSetVo.getSellerOrgId();

			if (buyerOrgId != null)
			{
				System.out.println("buyerorgId:" + buyerOrgId);
				Organization buyerOrg = orgService.getById(buyerOrgId);
				System.out.println("buyerOrg:" + buyerOrg);
				if (buyerOrg == null)
				{
					throw new OrganizationNotFoundException("Organization is not available with id " + buyerOrgId);
				}
				else
				{
					rateSet.setBuyerOrgId(buyerOrgId);
				}
			}

			if (sellerOrgId != null)
			{
				Organization sellerOrg = orgService.getById(sellerOrgId);

				if (sellerOrg == null)
				{
					throw new OrganizationNotFoundException("Organization is not available with id " + sellerOrgId);
				}
				else
				{
					rateSet.setSellerOrgId(sellerOrgId);
				}
			}
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
			for (RateTableVo rateTableVo : rateTableVos)
			{
				RateTable table = RateTableConverter.convertToRateTable(rateTableVo);
				log.info("*************** table ::::" + table);
				table.setRateSetId(rateSet.getId());
				rateTables.add(table);
			}
			rateSet.setTables(rateTables);

			rateSet.setCreatedBy(rateSetVo.getCreatedBy());
			rateSet.setLastUpdatedBy(rateSetVo.getLastUpdatedBy());
			rateSet.setReviewedBy(rateSetVo.getReviewedBy());
			rateSet.setLastAssignedBy(rateSetVo.getLastAssignedBy());
			rateSet.setApprovers(rateSetVo.getApprovers());

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