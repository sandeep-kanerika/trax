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

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    
    public RateRowsHistory() {
    	
    }

	public RateRowsHistory(Long amendmentId, Integer amendmentType, String amendmentReferenceId,
			Long rootParentId, Long parentId, Integer version, Long buyerOrgId, Long sellerOrgId, String buyerOrgName,
			Long ratesetId, Long raterowId, Long tableId, Integer status, Timestamp dateRecorded, Timestamp dateCreated,
			Timestamp dateUpdated, String keyValueHash, String validationErrors, Boolean hasError,
			Date effectiveDateFrom, Date effectiveDateThru, Date effectiveDate, String originCountry,
			String destinationCountry, String originStateProv, String originCity, String destinationCity,
			String originPostalCode, String destinationPostalCode, String originPostalCodeRange,
			String destinationPostalCodeRange, String originAirportCode, String destinationAirportCode,
			String originGateway, String destinationGateway, String originPortCountry, String destinationPortCountry,
			String originPortCity, String destinationPortCity, String originUnlocode, String destinationUnlocode,
			String originZone, String destinationZone, Double weightRangeFrom, Double weightRangeTo, Double weight,
			String equipmentType, String containerType, String vehicleType, String commodityType, String commodityClass,
			String volumetric, String mode, String modeType, String serviceScope, String serviceLevel,
			String packageType, String programName, String chargeDescription, String chargeCode, String rateBasic,
			String rateBasicUom, String rateType, Double rate, Double currency, Double baseRate, Double minRate,
			Double maxRate, Boolean breakpointFlag, Boolean consolidatedFlag, String tariffName, String discountFlag,
			String primaryIntermediateAirport, String primaryIntermediatePort, String backupIntermediatePort,
			String primarySubCarrier, String backupSubCarrier, Integer transitTime, String routeFrequency) {
		super();
		this.amendmentId = amendmentId;
		this.amendmentType = amendmentType;
		this.amendmentReferenceId = amendmentReferenceId;
		this.rootParentId = rootParentId;
		this.parentId = parentId;
		this.version = version;
		this.buyerOrgId = buyerOrgId;
		this.sellerOrgId = sellerOrgId;
		this.buyerOrgName = buyerOrgName;
		this.ratesetId = ratesetId;
		this.raterowId = raterowId;
		this.tableId = tableId;
		this.status = status;
		this.dateRecorded = dateRecorded;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
		this.keyValueHash = keyValueHash;
		this.validationErrors = validationErrors;
		this.hasError = hasError;
		this.effectiveDateFrom = effectiveDateFrom;
		this.effectiveDateThru = effectiveDateThru;
		this.effectiveDate = effectiveDate;
		this.originCountry = originCountry;
		this.destinationCountry = destinationCountry;
		this.originStateProv = originStateProv;
		this.originCity = originCity;
		this.destinationCity = destinationCity;
		this.originPostalCode = originPostalCode;
		this.destinationPostalCode = destinationPostalCode;
		this.originPostalCodeRange = originPostalCodeRange;
		this.destinationPostalCodeRange = destinationPostalCodeRange;
		this.originAirportCode = originAirportCode;
		this.destinationAirportCode = destinationAirportCode;
		this.originGateway = originGateway;
		this.destinationGateway = destinationGateway;
		this.originPortCountry = originPortCountry;
		this.destinationPortCountry = destinationPortCountry;
		this.originPortCity = originPortCity;
		this.destinationPortCity = destinationPortCity;
		this.originUnlocode = originUnlocode;
		this.destinationUnlocode = destinationUnlocode;
		this.originZone = originZone;
		this.destinationZone = destinationZone;
		this.weightRangeFrom = weightRangeFrom;
		this.weightRangeTo = weightRangeTo;
		this.weight = weight;
		this.equipmentType = equipmentType;
		this.containerType = containerType;
		this.vehicleType = vehicleType;
		this.commodityType = commodityType;
		this.commodityClass = commodityClass;
		this.volumetric = volumetric;
		this.mode = mode;
		this.modeType = modeType;
		this.serviceScope = serviceScope;
		this.serviceLevel = serviceLevel;
		this.packageType = packageType;
		this.programName = programName;
		this.chargeDescription = chargeDescription;
		this.chargeCode = chargeCode;
		this.rateBasic = rateBasic;
		this.rateBasicUom = rateBasicUom;
		this.rateType = rateType;
		this.rate = rate;
		this.currency = currency;
		this.baseRate = baseRate;
		this.minRate = minRate;
		this.maxRate = maxRate;
		this.breakpointFlag = breakpointFlag;
		this.consolidatedFlag = consolidatedFlag;
		this.tariffName = tariffName;
		this.discountFlag = discountFlag;
		this.primaryIntermediateAirport = primaryIntermediateAirport;
		this.primaryIntermediatePort = primaryIntermediatePort;
		this.backupIntermediatePort = backupIntermediatePort;
		this.primarySubCarrier = primarySubCarrier;
		this.backupSubCarrier = backupSubCarrier;
		this.transitTime = transitTime;
		this.routeFrequency = routeFrequency;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAmendmentId() {
		return amendmentId;
	}

	public void setAmendmentId(Long amendmentId) {
		this.amendmentId = amendmentId;
	}

	public Integer getAmendmentType() {
		return amendmentType;
	}

	public void setAmendmentType(Integer amendmentType) {
		this.amendmentType = amendmentType;
	}

	public String getAmendmentReferenceId() {
		return amendmentReferenceId;
	}

	public void setAmendmentReferenceId(String amendmentReferenceId) {
		this.amendmentReferenceId = amendmentReferenceId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Long getBuyerOrgId() {
		return buyerOrgId;
	}

	public void setBuyerOrgId(Long buyerOrgId) {
		this.buyerOrgId = buyerOrgId;
	}

	public Long getSellerOrgId() {
		return sellerOrgId;
	}

	public void setSellerOrgId(Long sellerOrgId) {
		this.sellerOrgId = sellerOrgId;
	}

	public String getBuyerOrgName() {
		return buyerOrgName;
	}

	public void setBuyerOrgName(String buyerOrgName) {
		this.buyerOrgName = buyerOrgName;
	}

//	public String getSellerOrgName() {
//		return sellerOrgName;
//	}
//
//	public void setSellerOrgName(String sellerOrgName) {
//		this.sellerOrgName = sellerOrgName;
//	}

	public Long getRatesetId() {
		return ratesetId;
	}

	public void setRateSetId(Long ratesetId) {
		this.ratesetId = ratesetId;
	}

	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Timestamp getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Timestamp dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getKeyValueHash() {
		return keyValueHash;
	}

	public void setKeyValueHash(String keyValueHash) {
		this.keyValueHash = keyValueHash;
	}

	public String getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(String validationErrors) {
		this.validationErrors = validationErrors;
	}

	public Boolean getHasError() {
		return hasError;
	}

	public void setHasError(Boolean hasError) {
		this.hasError = hasError;
	}

	public Date getEffectiveDateFrom() {
		return effectiveDateFrom;
	}

	public void setEffectiveDateFrom(Date effectiveDateFrom) {
		this.effectiveDateFrom = effectiveDateFrom;
	}

	public Date getEffectiveDateThru() {
		return effectiveDateThru;
	}

	public void setEffectiveDateThru(Date effectiveDateThru) {
		this.effectiveDateThru = effectiveDateThru;
	}

	public String getOriginCountry() {
		return originCountry;
	}

	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}

	public String getDestinationCountry() {
		return destinationCountry;
	}

	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}

	public String getOriginStateProv() {
		return originStateProv;
	}

	public void setOriginStateProv(String originStateProv) {
		this.originStateProv = originStateProv;
	}

	public String getOriginCity() {
		return originCity;
	}

	public void setOriginCity(String originCity) {
		this.originCity = originCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public String getOriginPostalCode() {
		return originPostalCode;
	}

	public void setOriginPostalCode(String originPostalCode) {
		this.originPostalCode = originPostalCode;
	}

	public String getDestinationPostalCode() {
		return destinationPostalCode;
	}

	public void setDestinationPostalCode(String destinationPostalCode) {
		this.destinationPostalCode = destinationPostalCode;
	}

	public String getOriginPostalCodeRange() {
		return originPostalCodeRange;
	}

	public void setOriginPostalCodeRange(String originPostalCodeRange) {
		this.originPostalCodeRange = originPostalCodeRange;
	}

	public String getOriginAirportCode() {
		return originAirportCode;
	}

	public void setOriginAirportCode(String originAirportCode) {
		this.originAirportCode = originAirportCode;
	}

	public String getDestinationAirportCode() {
		return destinationAirportCode;
	}

	public void setDestinationAirportCode(String destinationAirportCode) {
		this.destinationAirportCode = destinationAirportCode;
	}

	public String getOriginGateway() {
		return originGateway;
	}

	public void setOriginGateway(String originGateway) {
		this.originGateway = originGateway;
	}

	public String getDestinationGateway() {
		return destinationGateway;
	}

	public void setDestinationGateway(String destinationGateway) {
		this.destinationGateway = destinationGateway;
	}


	public String getOriginPortCity() {
		return originPortCity;
	}

	public void setOriginPortCity(String originPortCity) {
		this.originPortCity = originPortCity;
	}

	public String getDestinationPortCity() {
		return destinationPortCity;
	}

	public void setDestinationPortCity(String destinationPortCity) {
		this.destinationPortCity = destinationPortCity;
	}

	public String getOriginUnlocode() {
		return originUnlocode;
	}

	public void setOriginUnlocode(String originUnlocode) {
		this.originUnlocode = originUnlocode;
	}

	public String getDestinationUnlocode() {
		return destinationUnlocode;
	}

	public void setDestinationUnlocode(String destinationUnlocode) {
		this.destinationUnlocode = destinationUnlocode;
	}

	public String getOriginZone() {
		return originZone;
	}

	public void setOriginZone(String originZone) {
		this.originZone = originZone;
	}

	public String getDestinationZone() {
		return destinationZone;
	}

	public void setDestinationZone(String destinationZone) {
		this.destinationZone = destinationZone;
	}

	public Double getWeightRangeFrom() {
		return weightRangeFrom;
	}

	public void setWeightRangeFrom(Double weightRangeFrom) {
		this.weightRangeFrom = weightRangeFrom;
	}

	public Double getWeightRangeTo() {
		return weightRangeTo;
	}

	public void setWeightRangeTo(Double weightRangeTo) {
		this.weightRangeTo = weightRangeTo;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getContainerType() {
		return containerType;
	}

	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	public String getCommodityType() {
		return commodityType;
	}

	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getCommodityClass() {
		return commodityClass;
	}

	public void setCommodityClass(String commodityClass) {
		this.commodityClass = commodityClass;
	}

	public String getVolumetric() {
		return volumetric;
	}

	public void setVolumetric(String volumetric) {
		this.volumetric = volumetric;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getModeType() {
		return modeType;
	}

	public void setModeType(String modeType) {
		this.modeType = modeType;
	}

	public String getServiceScope() {
		return serviceScope;
	}

	public void setServiceScope(String serviceScope) {
		this.serviceScope = serviceScope;
	}

	public String getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getChargeDescription() {
		return chargeDescription;
	}

	public void setChargeDescription(String chargeDescription) {
		this.chargeDescription = chargeDescription;
	}

	public String getChargeCode() {
		return chargeCode;
	}

	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
	}

	public String getrateBasic() {
		return rateBasic;
	}

	public void setrateBasic(String rateBasic) {
		this.rateBasic = rateBasic;
	}

	public String getRateBasicUom() {
		return rateBasicUom;
	}

	public void setRateBasicUom(String rateBasicUom) {
		this.rateBasicUom = rateBasicUom;
	}

	public String getRateType() {
		return rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Double getCurrency() {
		return currency;
	}

	public void setCurrency(Double currency) {
		this.currency = currency;
	}

	public Double getBaseRate() {
		return baseRate;
	}

	public void setBaseRate(Double baseRate) {
		this.baseRate = baseRate;
	}

	public Double getMinRate() {
		return minRate;
	}

	public void setMinRate(Double minRate) {
		this.minRate = minRate;
	}

	public Double getMaxRate() {
		return maxRate;
	}

	public void setMaxRate(Double maxRate) {
		this.maxRate = maxRate;
	}

	public Boolean getBreakpointFlag() {
		return breakpointFlag;
	}

	public void setBreakpointFlag(Boolean breakpointFlag) {
		this.breakpointFlag = breakpointFlag;
	}

	public Boolean getconsolidatedFlag() {
		return consolidatedFlag;
	}

	public void setconsolidatedFlag(Boolean consolidatedFlag) {
		this.consolidatedFlag = consolidatedFlag;
	}

	public String getTariffName() {
		return tariffName;
	}

	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
	}

	public String getDiscountFlag() {
		return discountFlag;
	}

	public void setDiscountFlag(String discountFlag) {
		this.discountFlag = discountFlag;
	}

	public String getPrimaryIntermediateAirport() {
		return primaryIntermediateAirport;
	}

	public void setPrimaryIntermediateAirport(String primaryIntermediateAirport) {
		this.primaryIntermediateAirport = primaryIntermediateAirport;
	}

	public String getPrimarySubCarrier() {
		return primarySubCarrier;
	}

	public void setPrimarySubCarrier(String primarySubCarrier) {
		this.primarySubCarrier = primarySubCarrier;
	}

	public String getBackupSubCarrier() {
		return backupSubCarrier;
	}

	public void setBackupSubCarrier(String backupSubCarrier) {
		this.backupSubCarrier = backupSubCarrier;
	}

	public Integer getTransitTime() {
		return transitTime;
	}

	public void setTransitTime(Integer transitTime) {
		this.transitTime = transitTime;
	}

	public String getRouteFrequency() {
		return routeFrequency;
	}

	public void setRouteFrequency(String routeFrequency) {
		this.routeFrequency = routeFrequency;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getDateRecorded() {
		return dateRecorded;
	}

	public void setDateRecorded(Timestamp dateRecorded) {
		this.dateRecorded = dateRecorded;
	}

	public String getPrimaryIntermediatePort() {
		return primaryIntermediatePort;
	}

	public void setPrimaryIntermediatePort(String primaryIntermediatePort) {
		this.primaryIntermediatePort = primaryIntermediatePort;
	}

	public String getBackupIntermediatePort() {
		return backupIntermediatePort;
	}

	public void setBackupIntermediatePort(String backupIntermediatePort) {
		this.backupIntermediatePort = backupIntermediatePort;
	}

	public Long getRootParentId() {
		return rootParentId;
	}

	public void setRootParentId(Long rootParentId) {
		this.rootParentId = rootParentId;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getDestinationPostalCodeRange() {
		return destinationPostalCodeRange;
	}

	public void setDestinationPostalCodeRange(String destinationPostalCodeRange) {
		this.destinationPostalCodeRange = destinationPostalCodeRange;
	}

	public String getOriginPortCountry() {
		return originPortCountry;
	}

	public void setOriginPortCountry(String originPortCountry) {
		this.originPortCountry = originPortCountry;
	}

	public String getDestinationPortCountry() {
		return destinationPortCountry;
	}

	public void setDestinationPortCountry(String destinationPortCountry) {
		this.destinationPortCountry = destinationPortCountry;
	}

	public Long getRaterowId() {
		return raterowId;
	}

	public void setRaterowId(Long raterowId) {
		this.raterowId = raterowId;
	}
    
}
