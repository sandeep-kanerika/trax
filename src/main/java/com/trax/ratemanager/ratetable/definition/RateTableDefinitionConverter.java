package com.trax.ratemanager.ratetable.definition;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RateTableDefinitionConverter {
	
	public static RateTableDefinition convertToRateTableDefinition(RateTableDefinitionVo rateTableDefinitionVo) throws Exception {
		RateTableDefinition rateTableDefinition = null;
		if(rateTableDefinitionVo != null) {
			rateTableDefinition = new RateTableDefinition();
			log.info("***************Rate Table Definition id in convertor ::::" + rateTableDefinitionVo.getId());

			rateTableDefinition.setId(rateTableDefinitionVo.getId());
			//rateTableDefinition.setRateSetDefinition(rateSetDefinition);
			rateTableDefinition.setCreatorOrgId(rateTableDefinitionVo.getCreatorOrgId());
			rateTableDefinition.setName(rateTableDefinitionVo.getName());
			rateTableDefinition.setDateCreated(rateTableDefinitionVo.getDateCreated());
			rateTableDefinition.setTableGroup(rateTableDefinitionVo.getTableGroup());
			rateTableDefinition.setTableType(rateTableDefinitionVo.getTableType());
			rateTableDefinition.setColumnHash(rateTableDefinitionVo.getColumnHash());
			rateTableDefinition.setColumns(rateTableDefinitionVo.getColumns());
			log.info("***************Rate Table Definition Object in Rate Table Definition Convert :::" + rateTableDefinition);
			return rateTableDefinition;
		}else {
			throw new Exception("Problem with input");
		}
		
	}
}
