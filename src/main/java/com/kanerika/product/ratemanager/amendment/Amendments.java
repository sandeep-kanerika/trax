package com.kanerika.product.ratemanager.amendment;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.kanerika.product.ratemanager.config.AppConstants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by sudhakar.rao on 2/18/2019.
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private String createdBy;
    private String lastUpdatedBy;
    private String lastAssignedBy;
    private String approvers;
    private Long currentApprover;

    @JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
    private Timestamp dateApproved;

    @JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
    private Timestamp dateCreated;

    @JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
    private Timestamp dateUpdated;

    @JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
    private Timestamp dateReviewed;

    @JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
    private Timestamp dateAssigned;


}
