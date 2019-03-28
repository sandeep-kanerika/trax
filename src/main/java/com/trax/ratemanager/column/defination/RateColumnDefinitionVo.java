package com.trax.ratemanager.column.defination;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RateColumnDefinitionVo {

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
