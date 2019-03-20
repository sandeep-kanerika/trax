package com.trax.ratemanager.column.defination;

public class ColumnDefinitionConverter {

	public static RateColumnDefinition convertToRateColumnDefinition(ColumnDefinitionVo columnDefinitionVo) throws Exception{
		
		RateColumnDefinition rateColumnDefinition = null;
		if(columnDefinitionVo != null) {
			rateColumnDefinition = new RateColumnDefinition();
			
			System.out.println("existing id:::" + columnDefinitionVo.getId());
			
			rateColumnDefinition.setId(columnDefinitionVo.getId());
			rateColumnDefinition.setConcept(columnDefinitionVo.getConcept());
			rateColumnDefinition.setName(columnDefinitionVo.getName());
			rateColumnDefinition.setSortOrder(Long.getLong(columnDefinitionVo.getSortOrder()));
			rateColumnDefinition.setType(columnDefinitionVo.getType());
			rateColumnDefinition.setDateSourceId(columnDefinitionVo.getDateSourceId());
			rateColumnDefinition.setDateFieldId(columnDefinitionVo.getDateFieldId());
			rateColumnDefinition.setHasAlias(Boolean.valueOf(columnDefinitionVo.getHasAlias()));
			rateColumnDefinition.setIsKey(Boolean.valueOf(columnDefinitionVo.getIsKey()));
			rateColumnDefinition.setReference(columnDefinitionVo.getReference());
			rateColumnDefinition.setPivotField(columnDefinitionVo.getPivotField());
			rateColumnDefinition.setDisplayName(columnDefinitionVo.getDisplayName());
			rateColumnDefinition.setPivotCharge(columnDefinitionVo.getPivotCharge());
			rateColumnDefinition.setDescription(columnDefinitionVo.getDescription());
			
			return rateColumnDefinition;
		}else {
			throw new Exception("Problem with input");
		}
		
	}
	
	public static ColumnDefinitionVo convertToRateSetVo(RateColumnDefinition rateColumnDefinition) 
	{
		String id = rateColumnDefinition.getId();
		ColumnDefinitionVo columnDefinitionVo = new ColumnDefinitionVo();
		columnDefinitionVo.setId(id);
		return columnDefinitionVo;
	}
}
