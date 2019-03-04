package com.kanerika.product.ratemanager.column.definition;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ColumnDefinitions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
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
	
	public ColumnDefinitions() {
		
	}
	
	public ColumnDefinitions(String concept, String name, Long sortOrder, String type, String dateSourceId,
			String dateFieldId, String reference, String displayName, String propertyName, String pivotCharge,
			String description, Boolean hasAlias, Boolean isKey, String pivotField) {
		super();
		this.concept = concept;
		this.name = name;
		this.sortOrder = sortOrder;
		this.type = type;
		this.dateSourceId = dateSourceId;
		this.dateFieldId = dateFieldId;
		this.reference = reference;
		this.displayName = displayName;
		this.propertyName = propertyName;
		this.pivotCharge = pivotCharge;
		this.description = description;
		this.hasAlias = hasAlias;
		this.isKey = isKey;
		this.pivotField = pivotField;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the concept
	 */
	public String getConcept() {
		return concept;
	}

	/**
	 * @param concept the concept to set
	 */
	public void setConcept(String concept) {
		this.concept = concept;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the sortOrder
	 */
	public Long getSortOrder() {
		return sortOrder;
	}

	/**
	 * @param sortOrder the sortOrder to set
	 */
	public void setSortOrder(Long sortOrder) {
		this.sortOrder = sortOrder;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the dataSourceId
	 */
	public String getDateSourceId() {
		return dateSourceId;
	}

	/**
	 * @param dataSourceId the dataSourceId to set
	 */
	public void setDateSourceId(String dateSourceId) {
		this.dateSourceId = dateSourceId;
	}

	/**
	 * @return the dataFieldId
	 */
	public String getDateFieldId() {
		return dateFieldId;
	}

	/**
	 * @param dataFieldId the dataFieldId to set
	 */
	public void setDateFieldId(String dateFieldId) {
		this.dateFieldId = dateFieldId;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * @param propertyName the propertyName to set
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * @return the pivotCharge
	 */
	public String getPivotCharge() {
		return pivotCharge;
	}

	/**
	 * @param pivotCharge the pivotCharge to set
	 */
	public void setPivotCharge(String pivotCharge) {
		this.pivotCharge = pivotCharge;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the hasAlias
	 */
	public Boolean getHasAlias() {
		return hasAlias;
	}

	/**
	 * @param hasAlias the hasAlias to set
	 */
	public void setHasAlias(Boolean hasAlias) {
		this.hasAlias = hasAlias;
	}

	/**
	 * @return the isKey
	 */
	public Boolean getIsKey() {
		return isKey;
	}

	/**
	 * @param isKey the isKey to set
	 */
	public void setIsKey(Boolean isKey) {
		this.isKey = isKey;
	}

	/**
	 * @return the pivoteField
	 */
	public String getPivotField() {
		return pivotField;
	}

	/**
	 * @param pivoteField the pivoteField to set
	 */
	public void setPivotField(String pivotField) {
		this.pivotField = pivotField;
	}

}
