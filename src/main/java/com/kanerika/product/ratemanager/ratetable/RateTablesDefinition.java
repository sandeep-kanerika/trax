package com.kanerika.product.ratemanager.ratetable;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.kanerika.product.ratemanager.config.AppConstants;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RateTablesDefinition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private Long creatorOrgId;
    private String name;
    @JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
    private Timestamp dateCreated;
    private String tableGroup;
    private String tableType;
    private String columnHash;
    private String columns;
    
    public RateTablesDefinition() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreatorOrgId() {
		return creatorOrgId;
	}

	public void setCreatorOrgId(Long creatorOrgId) {
		this.creatorOrgId = creatorOrgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getTableGroup() {
		return tableGroup;
	}

	public void setTable_group(String tableGroup) {
		this.tableGroup = tableGroup;
	}

	public String getTableType() {
		return tableType;
	}

	public void setTable_type(String tableType) {
		this.tableType = tableType;
	}

	public String getColumnHash() {
		return columnHash;
	}

	public void setColumnHash(String columnHash) {
		this.columnHash = columnHash;
	}

	public String getColumns() {
		return columns;
	}

	public void setColumns(String columns) {
		this.columns = columns;
	}

	public RateTablesDefinition(Long id, Long creatorOrgId, String name, Timestamp dateCreated, String tableGroup,
			String tableType, String columnHash, String columns) {
		super();
		this.id = id;
		this.creatorOrgId = creatorOrgId;
		this.name = name;
		this.dateCreated = dateCreated;
		this.tableGroup = tableGroup;
		this.tableType = tableType;
		this.columnHash = columnHash;
		this.columns = columns;
	}
    
}
