package com.trax.ratemanager.column.defination;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RateColumnDefinitionConverter {

	public static RateColumnDefinition convertToRateColumnDefinition(RateColumnDefinitionVo columnDefinitionVo) throws Exception{
		
		RateColumnDefinition rateColumnDefinition = null;
		if(columnDefinitionVo != null) {
			rateColumnDefinition = new RateColumnDefinition();
			
			log.info("***************existing id in convertor ::::" + columnDefinitionVo.getId());
			
			rateColumnDefinition.setId(columnDefinitionVo.getId());
			rateColumnDefinition.setConcept(columnDefinitionVo.getConcept());
			rateColumnDefinition.setName(columnDefinitionVo.getName());
			rateColumnDefinition.setPropertyName(columnDefinitionVo.getPropertyName());
			rateColumnDefinition.setSortOrder(Long.valueOf(columnDefinitionVo.getSortOrder()));
			rateColumnDefinition.setType(columnDefinitionVo.getType());
			rateColumnDefinition.setDataSourceId(columnDefinitionVo.getDataSourceId());
			rateColumnDefinition.setDataFieldId(columnDefinitionVo.getDataFieldId());
			rateColumnDefinition.setHasAlias(Boolean.valueOf(columnDefinitionVo.getHasAlias()));
			rateColumnDefinition.setIsKey(Boolean.valueOf(columnDefinitionVo.getIsKey()));
			rateColumnDefinition.setReference(columnDefinitionVo.getReference());
			rateColumnDefinition.setPivotField(columnDefinitionVo.getPivotField());
			rateColumnDefinition.setDisplayName(columnDefinitionVo.getDisplayName());
			rateColumnDefinition.setPivotCharge(columnDefinitionVo.getPivotCharge());
			rateColumnDefinition.setDescription(columnDefinitionVo.getDescription());
			
			log.info("***************Rate Column Definition Object in Rate Column Definition Convert:::" + rateColumnDefinition);
			return rateColumnDefinition;
		}else {
			throw new Exception("Problem with input");
		}
		
	}
	
	public static RateColumnDefinitionVo convertToRateSetVo(RateColumnDefinition rateColumnDefinition) 
	{
		String id = rateColumnDefinition.getId();
		RateColumnDefinitionVo columnDefinitionVo = new RateColumnDefinitionVo();
		columnDefinitionVo.setId(id);
		return columnDefinitionVo;
	}
}
