package com.trax.ratemanager.column.validation;

import com.trax.ratemanager.column.defination.RateColumnDefinition;

public class ColumnValidationsConverter {
	
	public static RateColumnValidation convertToRateColumnValidation(ColumnValidationVo columnValidationVo) throws Exception{
		
		RateColumnValidation rateColumnValidation = null;
		if(columnValidationVo != null) {
			rateColumnValidation = new RateColumnValidation();
			
			System.out.println("existing id:::" + columnValidationVo.getId());
			
			rateColumnValidation.setId(columnValidationVo.getId());
			
			return rateColumnValidation;
		}else {
			throw new Exception("Problem with input");
		}
	}
}
