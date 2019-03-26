package com.trax.ratemanager.ratecolumn;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RateColumnConverter {

	public static RateColumn convertToRateColumn(RateColumnVo rateColumnVo) throws Exception {
		RateColumn rateColumn = null;
		if (rateColumnVo != null) {
			rateColumn = new RateColumn();
			log.info("***************Rate Column in convertor ::::" + rateColumnVo.getId());

			rateColumn.setId(rateColumnVo.getId());
			rateColumn.setConcept(rateColumnVo.getConcept());
			rateColumn.setDataFieldId(rateColumnVo.getDataFieldId());
			rateColumn.setDataSourceId(rateColumnVo.getDataSourceId());
			rateColumn.setDescription(rateColumnVo.getDescription());
			rateColumn.setDisplayName(rateColumnVo.getDisplayName());
			rateColumn.setIsActive(rateColumnVo.getIsActive());
			rateColumn.setIsKey(rateColumnVo.getIsKey());
			rateColumn.setName(rateColumnVo.getName());
			rateColumn.setPivotCharge(rateColumnVo.getPivotCharge());
			rateColumn.setPivotField(rateColumnVo.getPivotField());
			rateColumn.setPropertyName(rateColumnVo.getPropertyName());
			rateColumn.setSortOrder(rateColumnVo.getSortOrder());
			rateColumn.setType(rateColumnVo.getType());
			rateColumn.setHasAlias(rateColumnVo.getHasAlias());
			rateColumn.setReference(rateColumnVo.getReference());
			
			log.info("***************Rate Column Object in Rate Column Convert :::" + rateColumn);
			return rateColumn;

		} else {
			throw new Exception("Problem with input");
		}
	}

	public static RateColumnVo convertToRateSetVo(RateColumn rateColumn) {
		String id = rateColumn.getId();
		RateColumnVo rateColumnVo = new RateColumnVo();
		rateColumnVo.setId(id);
		return rateColumnVo;
	}

}