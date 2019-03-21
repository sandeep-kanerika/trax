package com.trax.ratemanager.column.defination;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.column.validation.RateColumnValidation;

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
public class RateColumnDefinition {

	@Id
	private String id;
	private String concept;

	private String name;

	private Long sortOrder;

	private String type;

	private String dataSourceId;

	private String dataFieldId;

	private Boolean hasAlias;

	private Boolean isKey;

	private String reference;

	private String pivotField;

	private String displayName;

	private String propertyName;

	private String pivotCharge;

	private String description;

	@OneToOne
	private RateColumnValidation columnValidation;
}