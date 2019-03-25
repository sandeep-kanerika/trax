package com.trax.ratemanager.column.defination;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.trax.ratemanager.ratecolumn.RateColumn;
import com.trax.ratemanager.rateset.RateSet;
import com.trax.ratemanager.ratetable.RateTable;

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
	
}