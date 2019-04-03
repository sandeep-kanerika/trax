package com.trax.ratemanager.ratecolumn;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
public class RateColumnVo {

	private String id;
	private String concept;

	@JsonProperty("data_field_id")
	private String dataFieldId;

	@JsonProperty("data_source_id")
	private String dataSourceId;

	private String description;

	@JsonProperty("display_name")
	private String displayName;

	@JsonProperty("is_active")
	private Boolean isActive;

	@JsonProperty("is_key")
	private Boolean isKey;

	private String name;

	@JsonProperty("pivot_charge")
	private String pivotCharge;
	
	@JsonProperty("pivot_field")
	private String pivotField;
	
	@JsonProperty("property_name")
	private String propertyName;
	
	@JsonProperty("sort_order")
	private Integer sortOrder;
	
	private String type;

	@JsonProperty("has_alias")
	private String hasAlias;
	
	private String reference;

}
