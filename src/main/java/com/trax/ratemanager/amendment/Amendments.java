package com.trax.ratemanager.amendment;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.raterow.RateRow;
import com.trax.ratemaneger.utility.LastModifiedByUser;

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
@Table
public class Amendments {

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

	@OneToMany
	private List<RateRow> rateRows;

	private Date defaultEffectiveDateFrom;
	private Date defaultEffectiveDateThru;

	private String reviewedBy;

	@OneToOne
	private LastModifiedByUser lastUpdatedBy;

	private String lastAssignedBy;
	private String approvers;
	private Long currentApprover;

	private LocalDateTime dateApproved;

	private LocalDateTime dateCreated;

	private LocalDateTime dateUpdated;

	private LocalDateTime dateReviewed;

	private LocalDateTime dateAssigned;

}
