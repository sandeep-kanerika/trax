package com.trax.ratemanager.rateset;

import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.amendment.Amendments;
import com.trax.ratemanager.config.AppConstants;
import com.trax.ratemanager.ratetable.RateTables;
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
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	private Integer status;

	private String buyerOrgId;

	private String sellerOrgId;

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
	/*
	 * @OneToMany(cascade = CascadeType.ALL) private List<RateTables> tables;
	 * 
	 * @OneToMany(cascade = CascadeType.ALL) private List<Amendments> amendments;
	 */
	private Long reviewedBy;

	@ManyToOne
	private CreatedByUser createdBy;

	@ManyToOne
	private LastModifiedByUser lastUpdatedBy;

	private Long lastAssignedBy;

	private String approvers;

}
