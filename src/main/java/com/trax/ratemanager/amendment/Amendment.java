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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.orgnization.Organization;
import com.trax.ratemanager.raterow.RateRow;
import com.trax.ratemaneger.user.UserAuditor;

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
public class Amendment {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private Integer status;
	private String referenceId;
	private Integer type;
	private String description;
	// private String ratesetId;
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

	private Date defaultEffectiveDateFrom;
	private Date defaultEffectiveDateThru;

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
	private Long currentApprover;

	private ZonedDateTime dateApproved;

	private ZonedDateTime dateCreated;

	private ZonedDateTime dateUpdated;

	private ZonedDateTime dateReviewed;

	private ZonedDateTime dateAssigned;

}
