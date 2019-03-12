package com.trax.ratemanager.rateset;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.amendment.Amendments;
import com.trax.ratemanager.ratetable.RateTables;
import com.trax.ratemaneger.utility.CreatedByUser;
import com.trax.ratemaneger.utility.LastModifiedByUser;

import lombok.Data;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public class RateSets {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private Integer status;
    
	private String buyerOrgId;
	
	private String sellerOrgId;
	
	private String Name;
	
	private String region;
	
	private String mode;
	
    private LocalDateTime dateCreated;
    
    private LocalDateTime dateUpdated;

    private LocalDateTime dateReviewed;
    
    private Timestamp dateAssigned;
    
    private String tableHash;
    
    @OneToMany
    private List <RateTables> tables;
    
    @OneToMany
    private List <Amendments> amendments;
    
    private Long reviewedBy;
    @OneToOne
    private CreatedByUser createdBy;
    
    @OneToOne
    private LastModifiedByUser lastUpdatedBy;
    
    private Long lastAssignedBy;
    private String approvers;
    

}
