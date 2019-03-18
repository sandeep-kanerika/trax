package com.trax.ratemanager.rateset;

import java.time.ZonedDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trax.ratemanager.config.AppConstants;
import com.trax.ratemanager.ratetable.RateTable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RateSetVo {

	private String id;

	private String status;

	private String name;

	private String region;

	private String mode;

	private String meta;

	private String type;

	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	private ZonedDateTime dateCreated;

	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	private ZonedDateTime dateUpdated;

	private String dateReviewed;

	private String effectiveDateFrom;

	private String effectiveDateThru;

	private String earliestExpirationDate;

	private String buyerOrgId;

	private String sellerOrgId;

	private String buyerOrgName;

	private String sellerOrgName;

	private String dateAssigned;

	private String tableHash;

	private List<RateTable> tables;

	private String reviewedBy;

	/*
	 * private User createdBy;
	 * 
	 * private User lastUpdatedBy;
	 */
	
	private String lastAssignedBy;

	private String approvers;

}