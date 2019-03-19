package com.trax.ratemanager.ratecolumn;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.column.validation.ColumnValidation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RateColumnVo {

	private String id;
	private String columnDefinitionId;
	private String rateSetId;
	private String tableId;

	private ColumnValidation validation;

}
