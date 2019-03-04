package com.kanerika.product.ratemanager.rateset.definition;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.kanerika.product.ratemanager.config.AppConstants;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RateSetsDefinition {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer status;
    
	private Long creatorOrgId;
	
	private String region;
	
	private String mode;
	
	private String Name;
    
    @JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
    private Timestamp dateCreated;

    @JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
    private Timestamp dateUpdated;

    private String tableHash;
    
    private String tables;

    public RateSetsDefinition() {
    	
    }
    public RateSetsDefinition(Integer status, Long creatorOrgId, String region, String mode, String name,
			Timestamp dateCreated, Timestamp dateUpdated, String tableHash, String tables) {
		super();
		this.status = status;
		this.creatorOrgId = creatorOrgId;
		this.region = region;
		this.mode = mode;
		Name = name;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
		this.tableHash = tableHash;
		this.tables = tables;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Long getCreatorOrgId() {
		return creatorOrgId;
	}

	public void setCreatorOrgId(Long creatorOrgId) {
		this.creatorOrgId = creatorOrgId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getTableHash() {
		return tableHash;
	}

	public void setTableHash(String tableHash) {
		this.tableHash = tableHash;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Timestamp getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Timestamp dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getTables() {
		return tables;
	}

	public void setTables(String tables) {
		this.tables = tables;
	}

}
