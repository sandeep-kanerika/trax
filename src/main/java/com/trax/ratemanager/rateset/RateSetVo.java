package com.trax.ratemanager.rateset;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.ratetable.RateTable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RateSetVo {

	private String id;

	private String status;

	private String name;

	private String region;

	private String mode;

	private String meta;

	private String type;

	private ZonedDateTime dateCreated;

	private ZonedDateTime dateUpdated;

	private ZonedDateTime dateReviewed;
	
	private ZonedDateTime dateAssigned;

	private ZonedDateTime effectiveDateFrom;

	private ZonedDateTime effectiveDateThru;

	private String earliestExpirationDate;

	private String buyerOrgId;

	private String sellerOrgId;

	private String buyerOrgName;

	private String sellerOrgName;

	private String tableHash;

	private List<RateTable> tables;

	private String createdBy;
	
	private String reviewedBy;

	private String lastAssignedBy;
	
	private String LastUpdatedBy;

	private String approvers;

	private String lastUpdatedBy;

}