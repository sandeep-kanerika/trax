package com.trax.ratemanager.rateset;

import lombok.Data;

@Data
public class RateSetVO {

	private String id;

	private String status;

	private String name;

	private String region;

	private String mode;

	private String dateCreated;

	private String dateUpdated;

	private String dateReviewed;

	private String buyerOrgId;

	private String sellerOrgId;

	private String dateAssigned;

	private String tableHash;

	private String tables;

	private Long reviewedBy;

	private String createdBy;

	private String lastUpdatedBy;
	
	private String lastAssignedBy;
	
	private String approvers;

}
