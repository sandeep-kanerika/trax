package com.trax.ratemanager.amendment;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.config.AppConstants;
import com.trax.ratemanager.orgnization.Organization;
import com.trax.ratemanager.raterow.RateRow;
import com.trax.ratemaneger.user.UserAuditor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Amendment {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private Integer status;
	private String referenceId;
	@PositiveOrZero(message="Provided Amendment Type must be a zero or positive number.")
	private Integer type;
	@NotEmpty
	private String description;
//	private String ratesetId;
	private String ratesetReferenceId;

	@JsonIgnoreProperties("buyer")
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Organization buyerOrg;

	@JsonIgnoreProperties("seller")
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Organization sellerOrg;

	private String ratesetName;
	private String region;
	private String mode;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "amendmentId")
	private List<RateRow> rateRows;

	@JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
	private Date defaultEffectiveDateFrom;

	@JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
	private Date defaultEffectiveDateThru;

	private String reviewedBy;

	@JsonBackReference
	@NotFound(action = NotFoundAction.IGNORE)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "createdById")
	private UserAuditor createdBy;

	@JsonBackReference
	@NotFound(action = NotFoundAction.IGNORE)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "lastUpdatedById")
	private UserAuditor lastUpdatedBy;


	@JsonBackReference
	@NotFound(action = NotFoundAction.IGNORE)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "lastAssignedById")
	private UserAuditor lastAssignedBy;
	
	// Need to implement list of approvers yet..
	/*
	 * @NotFound(action = NotFoundAction.IGNORE)
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "approvers") private List<UserAuditor> approvers;
	 */	
	@JsonBackReference
	@NotFound(action = NotFoundAction.IGNORE)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "currentApproverId")
	private UserAuditor currentApprover;

	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	private ZonedDateTime dateApproved;

	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	private ZonedDateTime dateCreated;

	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	private ZonedDateTime dateUpdated;

	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	private ZonedDateTime dateReviewed;

	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	private ZonedDateTime dateAssigned;

}
