package com.kanerika.product.ratemanager.amendment.history;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.kanerika.product.ratemanager.config.AppConstants;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by sudhakar.rao on 2/18/2019.
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AmendmentsHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private Integer status;
    private Long amendmentId;

    private String actionType;

    @JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
    private Timestamp dateRecorded;
    private Long referenceId;
    private Integer type;
    private String description;
    private Long ratesetId;
    private Long ratesetReferenceId;
    private Long buyerOrgId;
    private Long sellerOrgId;
    private String buyerOrgName;
    private String sellerOrgName;
    private String ratesetName;
    private String region;
    private String mode;

    @JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
    private Date defaultEffectiveDateFrom;
    @JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
    private Date defaultEffectiveDateThru;

    @JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
    private Timestamp dateApproved;

    @JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
    private Timestamp dateCreated;

    @JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
    private Timestamp dateUpdated;

    @JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
    private Timestamp dateReviewed;

    @JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
    private Timestamp dateAssigned;
    
    private Long reviewedBy;
    private Long createdBy;
    private Long lastUpdatedBy;
    private Long lastAssignedBy;
    private String approvers;
    private Long currentApprover;
    
    public AmendmentsHistory() {
    }

    public AmendmentsHistory(Long amendmentId, String actionType, Timestamp dateRecorded, Long referenceId, Integer type, String description, Long ratesetId, Long ratesetReferenceId, Long buyerOrgId, Long sellerOrgId, String buyerOrgName, String sellerOrgName, String ratesetName, String region, String mode, Long reviewedBy, Long createdBy, Long lastUpdatedBy, Long lastAssignedBy, String approvers, Long currentApprover, Date defaultEffectiveDateFrom, Date defaultEffectiveDateThru, Timestamp dateApproved, Timestamp dateCreated, Timestamp dateUpdated, Timestamp dateReviewed, Timestamp dateAssigned) {
        this.amendmentId = amendmentId;
        this.actionType = actionType;
        this.dateRecorded = dateRecorded;
        this.referenceId = referenceId;
        this.type = type;
        this.description = description;
        this.ratesetId = ratesetId;
        this.ratesetReferenceId = ratesetReferenceId;
        this.buyerOrgId = buyerOrgId;
        this.sellerOrgId = sellerOrgId;
        this.buyerOrgName = buyerOrgName;
        this.sellerOrgName = sellerOrgName;
        this.ratesetName = ratesetName;
        this.region = region;
        this.mode = mode;
        this.reviewedBy = reviewedBy;
        this.createdBy = createdBy;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAssignedBy = lastAssignedBy;
        this.approvers = approvers;
        this.currentApprover = currentApprover;
        this.defaultEffectiveDateFrom = defaultEffectiveDateFrom;
        this.defaultEffectiveDateThru = defaultEffectiveDateThru;
        this.dateApproved = dateApproved;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.dateReviewed = dateReviewed;
        this.dateAssigned = dateAssigned;
    }

    public Long getAmendmentId() {
        return amendmentId;
    }

    public void setAmendmentId(Long amendmentId) {
        this.amendmentId = amendmentId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public Timestamp getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(Timestamp dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getRatesetId() {
        return ratesetId;
    }

    public void setRatesetId(Long ratesetId) {
        this.ratesetId = ratesetId;
    }

    public Long getRatesetReferenceId() {
        return ratesetReferenceId;
    }

    public void setRatesetReferenceId(Long ratesetReferenceId) {
        this.ratesetReferenceId = ratesetReferenceId;
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

    public String getRatesetName() {
        return ratesetName;
    }

    public void setRatesetName(String ratesetName) {
        this.ratesetName = ratesetName;
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

    public Long getCurrentApprover() {
        return currentApprover;
    }

    public void setCurrentApprover(Long currentApprover) {
        this.currentApprover = currentApprover;
    }

    public Date getDefaultEffectiveDateFrom() {
        return defaultEffectiveDateFrom;
    }

    public void setDefaultEffectiveDateFrom(Date defaultEffectiveDateFrom) {
        this.defaultEffectiveDateFrom = defaultEffectiveDateFrom;
    }

    public Date getDefaultEffectiveDateThru() {
        return defaultEffectiveDateThru;
    }

    public void setDefaultEffectiveDateThru(Date defaultEffectiveDateThru) {
        this.defaultEffectiveDateThru = defaultEffectiveDateThru;
    }

    public Timestamp getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(Timestamp dateApproved) {
        this.dateApproved = dateApproved;
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
}
