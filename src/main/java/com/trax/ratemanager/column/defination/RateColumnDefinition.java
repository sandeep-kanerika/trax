package com.trax.ratemanager.column.defination;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RateColumnDefinition {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
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
}