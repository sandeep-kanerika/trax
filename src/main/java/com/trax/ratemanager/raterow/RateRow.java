package com.trax.ratemanager.raterow;

import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.config.AppConstants;

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
public class RateRow
{
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private Integer amendmentType;
	private String parentId;

	@Version
	private Integer version;
	private String buyerOrgId;
	private String sellerOrgId;
	private String ratesetId;
	private String tableId;
	private Integer status;

	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	private ZonedDateTime dateCreated;

	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	private ZonedDateTime dateUpdated;

	private String keyValueHash;
	private String laneId;
	private String tableDefinition;
	private String validationErrors;
	private Boolean hasError;

	@JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
	private Date effectiveDateFrom;

	@JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
	private Date effectiveDateThru;

	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	private ZonedDateTime effectiveDate;

	private String originCountry;
	private String destinationCountry;
	private String originStateProv;
	private String destinationStateProv;
	private String originCity;
	private String destinationCity;
	private String originPostalCode;
	private String destinationPostalCode;
	private String originPostalCodeRange;
	private String originAirportCode;
	private String destinationAirportCode;
	private String originGateway;
	private String destinationGateway;
	private String originPortCountry;
	private String destinationPortCountry;
	private String originPortStateProv;
	private String destinationPortStateProv;
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
	private String currency;
	private Double baseRate;
	private Double minRate;
	private Double maxRate;
	private Boolean breakpointFlag;
	private Boolean consolidatedFlag;
	private String discountFlag;
	private String primaryIntermediateAirport;
	private String backupIntermediateString;
	private String primarySubCarrier;
	private String backupSubCarrier;
	private Integer transitTime;
	private String routeFrequency;
}
