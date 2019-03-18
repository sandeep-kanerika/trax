package com.trax.ratemanager.amendment;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.raterow.RateRow;
import com.trax.ratemaneger.user.LastModifiedByUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AmendmentVo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private Integer status;
	private String referenceId;
	private Integer type;
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

	private List<RateRow> rateRows;

	private Date defaultEffectiveDateFrom;
	private Date defaultEffectiveDateThru;

	private String reviewedBy;

	private LastModifiedByUser lastUpdatedBy;

	private String lastAssignedBy;
	private String approvers;
	private Long currentApprover;

	private ZonedDateTime dateApproved;

	private ZonedDateTime dateCreated;

	private ZonedDateTime dateUpdated;

	private ZonedDateTime dateReviewed;

	private ZonedDateTime dateAssigned;

}
