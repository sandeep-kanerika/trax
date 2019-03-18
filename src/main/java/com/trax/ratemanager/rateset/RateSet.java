package com.trax.ratemanager.rateset;

import java.time.ZonedDateTime;
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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.amendment.Amendment;
import com.trax.ratemanager.config.AppConstants;
import com.trax.ratemanager.orgnization.Organization;
import com.trax.ratemanager.ratetable.RateTable;
import com.trax.ratemaneger.utility.CreatedByUser;
import com.trax.ratemaneger.utility.LastModifiedByUser;

import lombok.Getter;
import lombok.Setter;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
public class RateSet {

	@Id
	private String id;

	private Integer status;

	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "buyerOrgId")
	private Organization buyerOrg;

	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "sellerOrgId")
	private Organization sellerOrg;

	private String name;

	private String region;

	private String mode;

	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	private ZonedDateTime dateCreated;

	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	private ZonedDateTime dateUpdated;

	@JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
	private ZonedDateTime dateReviewed;

	@JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
	private ZonedDateTime dateAssigned;

	private String tableHash;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "rateSetId")
	private List<RateTable> tables;

	@NotFound(action = NotFoundAction.IGNORE)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "rateSetId")
	private List<Amendment> amendments;

	private Long reviewedBy;

	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "createdBy")
	private CreatedByUser createdBy;

	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "lastModifiedBy")
	private LastModifiedByUser lastUpdatedBy;

	private Long lastAssignedBy;

	private String approvers;

}
