package com.trax.ratemanager.column.validation;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColumnValidationVo
{

	private String id;

	private String tableId;

	private String columnDefinitionId;

	private String rateSetId;

	@OneToOne
	private Validation validation;

}
