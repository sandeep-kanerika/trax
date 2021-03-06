package com.trax.ratemanager.amendment;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.raterow.RateRow;
import com.trax.ratemaneger.user.UserAuditor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class AmendmentVo
{

	private String id;
	private String buyerOrgId;
	private Integer status;
	private String sellerOrgId;
	private String ratesetId;
	private Boolean isSpotQuote;

	private UserAuditor createdBy;
	private UserAuditor lastUpdatedBy;

	private ZonedDateTime dateCreated;
	private ZonedDateTime dateUpdated;
	private Date defaultEffectiveDateFrom;
	private Date defaultEffectiveDateThru;
	private String description;
	private String ratesetReferenceId;
	private String referenceId;
	private String reviewedBy;
	private String type;
	private String buyerOrgName;
	private String sellerOrgName;
	private String ratesetName;
	private String region;
	private String mode;
	private List<RateRow> rateRows;
	private UserAuditor lastAssignedBy;
	// to be implemented later.
	// private List<UserAuditor> approvers;
	private UserAuditor currentApprover;

	private ZonedDateTime dateApproved;

	private ZonedDateTime dateReviewed;

	private ZonedDateTime dateAssigned;

}
