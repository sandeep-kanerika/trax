package com.kanerika.product.ratemanager.rateset;

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
public class RateSets {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer status;
    
	private Long buyerOrgId;
	
	private Long sellerOrgId;
	
	private String buyerOrgName;
	
	private String sellerOrgName;

	private String Name;
	
	private String region;
	
	private String mode;
	
    @JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
    private Timestamp dateCreated;
    
    @JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
    private Timestamp dateUpdated;

    @JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
    private Timestamp dateReviewed;
    
    @JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
    private Timestamp dateAssigned;
    
    private String tableHash;
    
    private String tables;
    
    private Long reviewedBy;
    private Long createdBy;
    private Long lastUpdatedBy;
    private Long lastAssignedBy;
    private String approvers;
    
    public RateSets() {
    	
    }
    
    public RateSets(Integer status, Long buyerOrgId, Long sellerOrgId, String buyerOrgName, String sellerOrgName,
			String name, String region, String mode, Timestamp dateCreated, Timestamp dateUpdated,
			Timestamp dateReviewed, Timestamp dateAssigned, String tableHash, String tables, Long reviewedBy,
			Long createdBy, Long lastUpdatedBy, Long lastAssignedBy, String approvers) {
		super();
		this.status = status;
		this.buyerOrgId = buyerOrgId;
		this.sellerOrgId = sellerOrgId;
		this.buyerOrgName = buyerOrgName;
		this.sellerOrgName = sellerOrgName;
		Name = name;
		this.region = region;
		this.mode = mode;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
		this.dateReviewed = dateReviewed;
		this.dateAssigned = dateAssigned;
		this.tableHash = tableHash;
		this.tables = tables;
		this.reviewedBy = reviewedBy;
		this.createdBy = createdBy;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastAssignedBy = lastAssignedBy;
		this.approvers = approvers;
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

	public Long getBuyerOrgId() {
		return buyerOrgId;
	}

	public void setBuyerOrgId(Long buyerOrgId) {
		this.buyerOrgId = buyerOrgId;
	}

	public Long getSellerOrgId() {
		return sellerOrgId;
	}

	public void setSellerOrgId(Long sellerOrgId) {
		this.sellerOrgId = sellerOrgId;
	}

	public String getBuyerOrgName() {
		return buyerOrgName;
	}

	public void setBuyerOrgName(String buyerOrgName) {
		this.buyerOrgName = buyerOrgName;
	}

	public String getSellerOrgName() {
		return sellerOrgName;
	}

	public void setSellerOrgName(String sellerOrgName) {
		this.sellerOrgName = sellerOrgName;
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

	public Timestamp getDateReviewed() {
		return dateReviewed;
	}

	public void setDateReviewed(Timestamp dateReviewed) {
		this.dateReviewed = dateReviewed;
	}

	public Timestamp getDateAssigned() {
		return dateAssigned;
	}

	public void setDateAssigned(Timestamp dateAssigned) {
		this.dateAssigned = dateAssigned;
	}

	public String getTableHash() {
		return tableHash;
	}

	public void setTableHash(String tableHash) {
		this.tableHash = tableHash;
	}

//	public String getTable() {
//		return table;
//	}
//
//	public void setTable(String table) {
//		this.table = table;
//	}

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

	public Long getReviewedBy() {
		return reviewedBy;
	}

	public void setReviewedBy(Long reviewedBy) {
		this.reviewedBy = reviewedBy;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Long getLastAssignedBy() {
		return lastAssignedBy;
	}

	public void setLastAssignedBy(Long lastAssignedBy) {
		this.lastAssignedBy = lastAssignedBy;
	}

	public String getApprovers() {
		return approvers;
	}

	public void setApprovers(String approvers) {
		this.approvers = approvers;
	}

}
