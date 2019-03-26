package com.trax.ratemanager.column.validation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ColumnValidationConverter {
	
	public static ColumnValidation convertToColumnValidation(ColumnValidationVo columnValidationVo) throws Exception{
		
		ColumnValidation columnValidation = null;
		if(columnValidationVo != null) {
			columnValidation = new ColumnValidation();
			
			log.info("***************existing id in convertor ::::" + columnValidationVo.getId());
			
			columnValidation.setId(columnValidationVo.getId());
			log.info("***************Column Validation Object in Amendment Convert:::" + columnValidation);
			return columnValidation;
		}else {
			throw new Exception("Problem with input");
		}
	}
}
