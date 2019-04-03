package com.trax.ratemanager.rateset;

import java.util.ArrayList;
import java.util.List;

import com.trax.ratemanager.config.AppConstants;
import com.trax.ratemanager.exception.ApplicationServicesDownException;
import com.trax.ratemanager.orgnization.OrganizationService;
import com.trax.ratemanager.ratecolumn.RateColumn;
import com.trax.ratemanager.ratecolumn.RateColumnConverter;
import com.trax.ratemanager.ratecolumn.RateColumnVo;
import com.trax.ratemanager.ratetable.RateTable;
import com.trax.ratemanager.ratetable.RateTableConverter;
import com.trax.ratemanager.ratetable.RateTableService;
import com.trax.ratemanager.ratetable.RateTableVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RateSetConverter {
	public RateSet convertToRateSet(RateSetVo rateSetVo, OrganizationService organizationService,RateTableService rateTableService) throws Exception {
		RateSet rateSet = null;
		if (rateSetVo != null) {
			rateSet = new RateSet();
			log.info("***************existing ratesetvo in convertor ::::" + rateSetVo);

			rateSet.setBuyerOrgId(rateSetVo.getBuyerOrgId());
			rateSet.setBuyerOrgName(rateSetVo.getSellerOrgId());
			
			rateSet.setSellerOrgId(rateSetVo.getSellerOrgId());
			rateSet.setSellerOrgName(rateSetVo.getSellerOrgId());
			
			String meta = rateSetVo.getMeta();
			
			if(meta =="approved")
			rateSet.setStatus(AppConstants.RATESTATUS_APPROVED);
			
			else if(rateSetVo.getMeta()=="draft")
				rateSet.setStatus(AppConstants.RATESTATUS_DRAFT);

			else if(rateSetVo.getMeta()=="rejected")
				rateSet.setStatus(AppConstants.RATESTATUS_REJECTED);

			else if(rateSetVo.getMeta()=="pending")
				rateSet.setStatus(AppConstants.RATESTATUS_PENDING);

			
			if (organizationService == null)
				throw new ApplicationServicesDownException("Organization service is down...");

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
			List<RateTable> rateTableList = new ArrayList<RateTable>();
			
			for (RateTableVo rateTableVo : rateTableVos) 
			{
				RateTable table = RateTableConverter.convertToRateTable(rateTableVo);
				log.info("*************** table ::::" + table);
				
				List<RateColumn> rateColumnsList = new ArrayList<RateColumn>();
				List<RateColumnVo> columns = rateTableVo.getColumns();
				for(RateColumnVo columnVo:columns) 
				{
					RateColumn rateColumn = RateColumnConverter.convertToRateColumn(columnVo);
					rateColumnsList.add(rateColumn);
					
				}
				table.setColumns(rateColumnsList);
				rateTableList.add(table);
			}
			rateSet.setTables(rateTableList);

			rateSet.setCreatedBy(rateSetVo.getCreatedBy());
			rateSet.setLastUpdatedBy(rateSetVo.getLastUpdatedBy());
			rateSet.setReviewedBy(rateSetVo.getReviewedBy());
			rateSet.setLastAssignedBy(rateSetVo.getLastAssignedBy());
			rateSet.setApprovers(rateSetVo.getApprovers());

			return rateSet;

		} else {
			throw new Exception("Problem with input");
		}

	}

	public static RateSetVo convertToRateSetVo(RateSet rateSet) {
		String id = rateSet.getId();
		RateSetVo rateSetVo = new RateSetVo();
		rateSetVo.setId(id);
		return rateSetVo;
	}

}