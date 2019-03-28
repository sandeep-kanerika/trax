package com.trax.ratemanager.rateset;

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
import com.trax.ratemanager.amendment.Amendment;
import com.trax.ratemanager.config.AppConstants;
import com.trax.ratemanager.orgnization.Organization;
import com.trax.ratemanager.ratetable.RateTable;

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
public class RateSet {

	@Id
	private String id;

	private Integer status;

	@JsonIgnoreProperties("buyer")
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Organization buyerOrg;

	@JsonIgnoreProperties("seller")
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Organization sellerOrg;

	private String name;

	private String region;

	private String mode;

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

	private String tableHash;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "rateSetId")
	private List<RateTable> tables;

	@NotFound(action = NotFoundAction.IGNORE)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "rateSetId")
	private List<Amendment> amendments;

	private String createdBy;

	private String reviewedBy;

	private String lastAssignedBy;

	private String lastUpdatedBy;

	private String approvers;

}
