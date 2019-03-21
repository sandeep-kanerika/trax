package com.trax.ratemanager.column.validation;

import com.trax.ratemanager.column.defination.RateColumnDefinition;

public class ColumnValidationConverter {
	
	public static ColumnValidation convertToColumnValidation(ColumnValidationVo columnValidationVo) throws Exception{
		
		ColumnValidation ColumnValidation = null;
		if(columnValidationVo != null) {
			ColumnValidation = new ColumnValidation();
			
			System.out.println("existing id:::" + columnValidationVo.getId());
			
			ColumnValidation.setId(columnValidationVo.getId());
			
			return ColumnValidation;
		}else {
			throw new Exception("Problem with input");
		}
	}
}
