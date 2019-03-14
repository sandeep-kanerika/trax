package com.trax.ratemanager.rateset;

import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.config.AppConstants;
import com.trax.ratemanager.ratetable.RateTables;

import lombok.Data;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public class RateSet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private Integer status;

	private String Name;

	private String region;

	private String mode;

	@JsonFormat(pattern = AppConstants.DEFAULT_LOCAL_DATETIME_FORMAT_WITH_ZONE)
	private ZonedDateTime dateCreated;

	@JsonFormat(pattern = AppConstants.DEFAULT_LOCAL_DATETIME_FORMAT_WITH_ZONE)
	private ZonedDateTime dateUpdated;

	private ZonedDateTime dateReviewed;
	
	/*
	 * private Organization buyerOrgId;
	 * 
	 * private Organization sellerOrgId;
	 */
	private ZonedDateTime dateAssigned;

	private String tableHash;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "rateSetId")
	private List<RateTables> tables;
	/*
	 * @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch =
	 * FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "rateSetId") private List<Amendments> amendments;
	 */
	private Long reviewedBy;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	// @JoinColumn(name = "rateSetId")
//	private User createdBy;

//	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	// @JoinColumn(name = "rateSetId")
//	private User lastUpdatedBy;

	private Long lastAssignedBy;
	private String approvers;

}
