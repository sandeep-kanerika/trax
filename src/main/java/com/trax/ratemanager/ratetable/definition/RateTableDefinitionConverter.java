package com.trax.ratemanager.ratetable.definition;

public class RateTableDefinitionConverter {
	
	public static RateTableDefinition convertToRateTable(RateTableDefinitionVo rateTableDefinitionVo) throws Exception {
		RateTableDefinition rateTableDefinition = null;
		if(rateTableDefinitionVo != null) {
			rateTableDefinition = new RateTableDefinition();
			System.out.println("existing id:::" + rateTableDefinitionVo.getId());

			rateTableDefinition.setId(rateTableDefinitionVo.getId());
			rateTableDefinition.setCreatorOrgId(Long.getLong(rateTableDefinitionVo.getCreatorOrgId()));
			rateTableDefinition.setName(rateTableDefinitionVo.getName());
			rateTableDefinition.setDateCreated(rateTableDefinitionVo.getDateCreated());
			rateTableDefinition.setTableGroup(rateTableDefinitionVo.getTableGroup());
			rateTableDefinition.setTableType(rateTableDefinitionVo.getTableType());
			rateTableDefinition.setColumnHash(rateTableDefinitionVo.getColumnHash());
			rateTableDefinition.setColumns(rateTableDefinitionVo.getColumns());
			
			return rateTableDefinition;
		}else {
			throw new Exception("Problem with input");
		}
		
	}
}
