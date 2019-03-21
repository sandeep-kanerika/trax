package com.trax.ratemanager.column.defination;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.column.validation.RateColumnValidation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColumnDefinitionVo {

	private String id;

	private String concept;

	private String name;

	private String sortOrder;

	private String type;

	private String dataSourceId;

	private String dataFieldId;

	private String hasAlias;

	private String isKey;

	private String reference;

	private String pivotField;

	private String displayName;

	private String propertyName;

	private String pivotCharge;

	private String description;
}
