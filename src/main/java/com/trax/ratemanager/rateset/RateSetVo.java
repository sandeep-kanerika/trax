package com.trax.ratemanager.rateset;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
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

	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	private ZonedDateTime dateReviewed;

	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	private ZonedDateTime dateAssigned;

	@JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
	private Date effectiveDateFrom;

	@JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
	private Date effectiveDateThru;

	private String earliestExpirationDate;

	private String buyerOrgId;

	private String sellerOrgId;

	private String buyerOrgName;

	private String sellerOrgName;

	private String tableHash;

	private List<RateTableVo> tables;

	private String createdBy;
	
	private String reviewedBy;

	private String lastAssignedBy;

	private String approvers;

	private String lastUpdatedBy;

}