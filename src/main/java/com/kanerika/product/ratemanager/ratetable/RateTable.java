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
public class RateTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private Long creator_org_id;
    private String name;
    @JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
    private Timestamp date_created;
    private String table_group;
    private String table_type;
    private String column_hash;
    private String columns;
    
    public RateTable() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreator_org_id() {
		return creator_org_id;
	}

	public void setCreator_org_id(Long creator_org_id) {
		this.creator_org_id = creator_org_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getDate_created() {
		return date_created;
	}

	public void setDate_created(Timestamp date_created) {
		this.date_created = date_created;
	}

	public String getTable_group() {
		return table_group;
	}

	public void setTable_group(String table_group) {
		this.table_group = table_group;
	}

	public String getTable_type() {
		return table_type;
	}

	public void setTable_type(String table_type) {
		this.table_type = table_type;
	}

	public String getColumn_hash() {
		return column_hash;
	}

	public void setColumn_hash(String column_hash) {
		this.column_hash = column_hash;
	}

	public String getColumns() {
		return columns;
	}

	public void setColumns(String columns) {
		this.columns = columns;
	}

	public RateTable(Long id, Long creator_org_id, String name, Timestamp date_created, String table_group,
			String table_type, String column_hash, String columns) {
		super();
		this.id = id;
		this.creator_org_id = creator_org_id;
		this.name = name;
		this.date_created = date_created;
		this.table_group = table_group;
		this.table_type = table_type;
		this.column_hash = column_hash;
		this.columns = columns;
	}
    
}
