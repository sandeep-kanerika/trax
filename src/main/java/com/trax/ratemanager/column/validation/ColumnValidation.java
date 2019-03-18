package com.trax.ratemanager.column.validation;

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
public class ColumnValidation {

	@Id
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

	private String description;
}
