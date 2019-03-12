package com.trax.ratemanager.rateset;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.amendment.Amendments;
import com.trax.ratemanager.ratetable.RateTables;

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
	
	private String Name;
	
	private String region;
	
	private String mode;
	
    private Timestamp dateCreated;
    
    private Timestamp dateUpdated;

    private Timestamp dateReviewed;
    
    private Timestamp dateAssigned;
    
    private String tableHash;
    
    @OneToMany
    private List <RateTables> tables;
    
    @OneToMany
    private List <Amendments> amendments;
    
    private Long reviewedBy;
    private Long createdBy;
    private Long lastUpdatedBy;
    private Long lastAssignedBy;
    private String approvers;
    

}
