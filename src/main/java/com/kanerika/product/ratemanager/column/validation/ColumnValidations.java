package com.kanerika.product.ratemanager.column.validation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ColumnValidations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long tableId;

	private Long columnDefinitionId;

	private Long rateSetId;
	
	private String validation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	public Long getColumnDefinitionId() {
		return columnDefinitionId;
	}

	public void setColumnDefinitionId(Long columnDefinitionId) {
		this.columnDefinitionId = columnDefinitionId;
	}

	public Long getRateSetId() {
		return rateSetId;
	}

	public void setRateSetId(Long rateSetId) {
		this.rateSetId = rateSetId;
	}

	public String getValidation() {
		return validation;
	}

	public void setValidation(String validation) {
		this.validation = validation;
	}

}
