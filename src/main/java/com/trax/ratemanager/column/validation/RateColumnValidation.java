package com.trax.ratemanager.column.validation;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.ratecolumn.RateColumn;

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
public class RateColumnValidation 
{
	@Id
	private String id;
	private String columnDefinitionId;
	private String concept;
	private String dataFieldId;
	private String dataSourceId;
	private String description;
	private String displayName;
	private Boolean isActive;
	private Boolean isRequired;
	private String name;
	private String pivotCharge;
	private String pivotField;
	private String propertyName;
	private Integer sortyOrder;
	private String type;
	private String[] validValues;
	private String validationType;

	@OneToOne(mappedBy = "validation", fetch = FetchType.LAZY)
	private RateColumn column;
}
