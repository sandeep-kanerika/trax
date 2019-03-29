package com.trax.ratemanager.ratecolumn;

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
public class RateColumnVo
{

	private String id;
	private String concept;
	private String dataFieldId;
	private String dataSourceId;
	private String description;
	private String displayName;
	private Boolean isActive;
	private Boolean isKey;
	private String name;
	private String pivotCharge;
	private String pivotField;
	private String propertyName;
	private Integer sortOrder;
	private String type;
	private String hasAlias;
	private String reference;

}
