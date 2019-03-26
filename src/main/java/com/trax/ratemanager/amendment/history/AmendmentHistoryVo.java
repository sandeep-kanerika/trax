package com.trax.ratemanager.amendment.history;

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
public class AmendmentHistoryVo {

	private String id;
	private String amendmentId;
	private String actionType;
	private ZonedDateTime dateRecorded;
	private String referenceId;
	private String type;
	private String description;
	private String ratesetId;
	private String ratesetReferenceId;
	private String buyerOrgId;
	private String sellerOrgId;
	private String buyerOrgName;
	private String sellerOrgName;
	private String ratesetName;
	private String region;
	private String mode;
	private String status;

	private UserAuditor createdBy;
	private ZonedDateTime dateCreated;
	private ZonedDateTime dateUpdated;
	private ZonedDateTime dateReviewed;
	private ZonedDateTime dateAssigned;
	private Date defaultEffectiveDateFrom;
	private Date defaultEffectiveDateThru;
	
	private UserAuditor lastUpdatedBy;
	private String reviewedBy;

	private List<RateRow> rateRows;
	private String lastAssignedBy;
	private String approvers;
	private String currentApprover;

}
