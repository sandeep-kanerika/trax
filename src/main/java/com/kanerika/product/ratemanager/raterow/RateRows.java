package com.kanerika.product.ratemanager.raterow;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

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
public class RateRows {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	private String amendmentId;
	
	private Integer amendmentType;
	
	private String amendmentReferenceId;
	
	private String parentId;
	
	private Integer version;

	private String buyerOrgId;

	private String sellerOrgId;
	
	private String buyerOrgName;
	
	private String sellerOrgName;

	private String ratesetId;
	
	private String tableId;
	
	private Integer status;
	
  //  @JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
    private LocalDate dateCreated;

 //   @JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
    private LocalDate dateUpdated;

	private String keyValueHash;
	
	private String laneId;
	
	private String tableDefinition;
	
	private String validationErrors;
	
	private Boolean hasError;

//    @JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
    private LocalDate effectiveDateFrom;

 //   @JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
    private LocalDate effectiveDateThru;
 //   
   // @JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
    private LocalDate effectiveDate;
    
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
