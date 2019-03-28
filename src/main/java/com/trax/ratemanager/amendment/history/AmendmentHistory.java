package com.trax.ratemanager.amendment.history;

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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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

/**
 * Created by sudhakar.rao on 2/18/2019.
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AmendmentHistory {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private Integer status;
	private String amendmentId;
	private String actionType;

	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	private ZonedDateTime dateRecorded;
	private String referenceId;
	private Integer type;
	private String description;
	private String ratesetId;
	private String ratesetReferenceId;
	
	@JsonIgnoreProperties("buyer")
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Organization buyerOrg;
	
	@JsonIgnoreProperties("seller")
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Organization sellerOrg;
//	private String buyerOrgName;
//	private String sellerOrgName;
	private String ratesetName;
	private String region;
	private String mode;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "amendmentHistoryId")
	private List<RateRow> rateRows;

	@JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
	private Date defaultEffectiveDateFrom;
	
	@JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
	private Date defaultEffectiveDateThru;
	
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

	private String reviewedBy;
	
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "createdById")
	private UserAuditor createdBy;
	
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "lastUpdatedById")
	private UserAuditor lastUpdatedBy;
	
	private String lastAssignedBy;
	private String approvers;
	private String currentApprover;
}
