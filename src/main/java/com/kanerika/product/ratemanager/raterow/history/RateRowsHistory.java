package com.kanerika.product.ratemanager.raterow.history;

import java.util.Date;
import java.sql.Timestamp;

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

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RateRowsHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long amendmentId;

	private Integer amendmentType;

	private String amendmentReferenceId;

	private Long rootParentId;

	private Long parentId;

	private Integer version;

	private Long buyerOrgId;

	private Long sellerOrgId;

	private String buyerOrgName;

	private Long ratesetId;

	private Long raterowId;

	private Long tableId;

	private Integer status;

	@JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
	private Timestamp dateRecorded;

	@JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
	private Timestamp dateCreated;

	@JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
	private Timestamp dateUpdated;

	private String keyValueHash;

	private String validationErrors;

	private Boolean hasError;

	@JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
	private Date effectiveDateFrom;

	@JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
	private Date effectiveDateThru;

	@JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
	private Date effectiveDate;

	private String originCountry;

	private String destinationCountry;

	private String originStateProv;

	private String originCity;

	private String destinationCity;

	private String originPostalCode;

	private String destinationPostalCode;

	private String originPostalCodeRange;

	private String destinationPostalCodeRange;

	private String originAirportCode;

	private String destinationAirportCode;

	private String originGateway;

	private String destinationGateway;

	private String originPortCountry;

	private String destinationPortCountry;

	private String originPortCity;

	private String destinationPortCity;

	private String originUnlocode;

	private String destinationUnlocode;

	private String originZone;

	private String destinationZone;

	private Double weightRangeFrom;

	private Double weightRangeTo;

	private Double weight;

	private String equipmentType;

	private String containerType;

	private String vehicleType;

	private String commodityType;

	private String commodityClass;

	private String volumetric;

	private String mode;

	private String modeType;

	private String serviceScope;

	private String serviceLevel;

	private String packageType;

	private String programName;

	private String chargeDescription;

	private String chargeCode;

	private String rateBasic;

	private String rateBasicUom;

	private String rateType;

	private Double rate;

	private Double currency;

	private Double baseRate;

	private Double minRate;

	private Double maxRate;

	private Boolean breakpointFlag;

	private Boolean consolidatedFlag;

	private String tariffName;

	private String discountFlag;

	private String primaryIntermediateAirport;

	private String primaryIntermediatePort;

	private String backupIntermediatePort;

	private String primarySubCarrier;

	private String backupSubCarrier;

	private Integer transitTime;

	private String routeFrequency;

}
