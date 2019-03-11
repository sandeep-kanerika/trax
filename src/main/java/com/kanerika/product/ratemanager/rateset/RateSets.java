package com.kanerika.product.ratemanager.rateset;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.kanerika.product.ratemanager.config.AppConstants;
import com.kanerika.product.ratemanager.ratetable.RateTablesDefinition;

import lombok.Data;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public class RateSets {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

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
    
    @OneToMany
    private List <RateTablesDefinition> tables;
    
    private Long reviewedBy;
    private Long createdBy;
    private Long lastUpdatedBy;
    private Long lastAssignedBy;
    private String approvers;
    

}
