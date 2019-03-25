package com.trax.ratemanager.ratecolumn;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RateColumn {

	@Id
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
