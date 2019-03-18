package com.trax.ratemanager.ratecolumn;

import java.util.List;

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

	private String concept;

	private String name;

	private Long sortOrder;

	private String type;

	private String dateSourceId;

	private String dateFieldId;

	private Boolean hasAlias;

	private Boolean isKey;

	private String reference;

	private String pivotField;

	private String displayName;

	private String propertyName;

	private String pivotCharge;

	private List<ColumnValidation> columnValidations;

	private String description;
}