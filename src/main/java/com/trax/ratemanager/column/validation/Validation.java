package com.trax.ratemanager.column.validation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Validation
{

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
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
}
