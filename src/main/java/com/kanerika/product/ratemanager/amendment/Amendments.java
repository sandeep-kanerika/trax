package com.kanerika.product.ratemanager.amendment;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.kanerika.product.ratemanager.config.AppConstants;
import com.kanerika.product.ratemanager.wrapper.CreatedByUser;

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

	@JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
	private Date defaultEffectiveDateFrom;
	@JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
	private Date defaultEffectiveDateThru;

	private String reviewedBy;

	@OneToOne
	@JoinColumn(name = "address_id")
	private CreatedByUser address;

	private String lastUpdatedBy;
	private String lastAssignedBy;
	private String approvers;
	private Long currentApprover;

	@JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
	private LocalDateTime dateApproved;

	@JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
	private LocalDateTime dateCreated;

	@JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
	private LocalDateTime dateUpdated;

	@JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
	private LocalDateTime dateReviewed;

	@JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
	private LocalDateTime dateAssigned;

}
