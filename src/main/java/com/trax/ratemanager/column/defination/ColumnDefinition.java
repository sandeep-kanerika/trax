package com.trax.ratemanager.column.defination;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.column.validation.ColumnValidation;

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
public class ColumnDefinition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany
	private List<ColumnValidation> columnValidations;

	private String description;
}
