package com.trax.ratemanager.rateset;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trax.ratemanager.config.AppConstants;
import com.trax.ratemanager.ratetable.RateTableVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RateSetVo
{

	private String id;
	private String status;
	private String name;
	private String region;
	private String mode;
	private String meta;
	private String type;

	@JsonProperty("earliest_expiration_date")
	private String earliestExpirationDate;
	
	@JsonProperty("buyer_org_id")
	private String buyerOrgId;
	
	@JsonProperty("seller_org_id")
	private String sellerOrgId;
	
	@JsonProperty("buyer_org_name")
	private String buyerOrgName;
	
	@JsonProperty("seller_org_name")
	private String sellerOrgName;
	
	@JsonProperty("table_hash")
	private String tableHash;
	
	@JsonProperty("created_by")
	private String createdBy;
	
	@JsonProperty("reviewed_by")
	private String reviewedBy;
	
	@JsonProperty("last_reviewed_by")
	private String lastAssignedBy;
	
	private String approvers;
	
	@JsonProperty("last_updated_by")
	private String lastUpdatedBy;

	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	@JsonProperty("date_created")
	private ZonedDateTime dateCreated;

	@JsonProperty("date_updated")
	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	private ZonedDateTime dateUpdated;

	@JsonProperty("date_reviewed")
	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	private ZonedDateTime dateReviewed;

	@JsonProperty("date_assigned")
	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	private ZonedDateTime dateAssigned;

	@JsonProperty("effective_date_from")
	@JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
	private Date effectiveDateFrom;

	@JsonProperty("effective_date_thru")
	@JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
	private Date effectiveDateThru;

	private List<RateTableVo> tables;

}