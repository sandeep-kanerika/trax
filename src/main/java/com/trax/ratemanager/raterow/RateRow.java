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
import com.fasterxml.jackson.annotation.JsonProperty;
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
	
	@JsonProperty("buyer_org_id")
	private String buyerOrgId;
	
	@JsonProperty("seller_org_id")
	private String sellerOrgId;
	
	@JsonProperty("rateset_id")
	private String ratesetId;
	
	@JsonProperty("table_id")
	private String tableId;
	
	private Integer status;

	@JsonProperty("date_created")
	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	private ZonedDateTime dateCreated;

	@JsonProperty("date_updated")
	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	private ZonedDateTime dateUpdated;

	@JsonProperty("key_value_hash")
	private String keyValueHash;
	
	@JsonProperty("lane_id")
	private String laneId;
	
	@JsonProperty("table_definition_id")
	private String tableDefinition;
	
	@JsonProperty("validation_errors")
	private String validationErrors;
	
	@JsonProperty("has_error")
	private Boolean hasError;

	@JsonProperty("effective_date_from")
	@JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
	private Date effectiveDateFrom;

	@JsonProperty("effective_date_thru")
	@JsonFormat(pattern = AppConstants.DEFAULT_DATE_FORMAT)
	private Date effectiveDateThru;

	@JsonProperty("effective_date")
	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	private ZonedDateTime effectiveDate;

	@JsonProperty("orgin_country")
	private String originCountry;
	
	@JsonProperty("destination_country")
	private String destinationCountry;
	
	@JsonProperty("orgin_state_prov")
	private String originStateProv;
	
	@JsonProperty("destination_state_prov")
	private String destinationStateProv;
	
	@JsonProperty("origin_city")
	private String originCity;
	
	@JsonProperty("destination_city")
	private String destinationCity;
	
	@JsonProperty("origin_postal_code")
	private String originPostalCode;
	
	@JsonProperty("destination_postal_code")
	private String destinationPostalCode;
	
	@JsonProperty("origin_postal_range")
	private String originPostalCodeRange;
	
	@JsonProperty("orgin_airport_code")
	private String originAirportCode;
	
	@JsonProperty("destination_airport_code")
	private String destinationAirportCode;
	
	@JsonProperty("origin_gateway")
	private String originGateway;
	
	@JsonProperty("destinition_gatway")
	private String destinationGateway;
	
	@JsonProperty("origin_port_country")
	private String originPortCountry;
	
	@JsonProperty("destination_port_country")
	private String destinationPortCountry;
	
	@JsonProperty("origin_port_state_prov")
	private String originPortStateProv;
	
	@JsonProperty("destination_port_state_prov")
	private String destinationPortStateProv;
	
	@JsonProperty("origin_port_city")
	private String originPortCity;
	
	@JsonProperty("destination_port_city")
	private String destinationPortCity;
	
	@JsonProperty("origin_unlocode")
	private String originUnlocode;
	
	@JsonProperty("destination_unlocode")
	private String destinationUnlocode;
	
	@JsonProperty("origin_zone")
	private String originZone;
	
	@JsonProperty("destination_zone")
	private String destinationZone;
	
	@JsonProperty("weight_range_from")
	private Double weightRangeFrom;
	
	@JsonProperty("weight_range_to")
	private Double weightRangeTo;
	
	private Double weight;

	@JsonProperty("equipment_type")
	private String equipmentType;
	
	@JsonProperty("container_type")
	private String containerType;
	
	@JsonProperty("vehicle_type")
	private String vehicleType;
	
	@JsonProperty("commodity_type")
	private String commodityType;
	
	@JsonProperty("commodity_class")
	private String commodityClass;
	
	private String volumetric;
	private String mode;

	@JsonProperty("mode_type")
	private String modeType;
	
	@JsonProperty("service_scope")
	private String serviceScope;
	
	@JsonProperty("service_level")
	private String serviceLevel;
	
	@JsonProperty("package_type")
	private String packageType;
	
	@JsonProperty("program_name")
	private String programName;
	
	@JsonProperty("charge_description")
	private String chargeDescription;
	
	@JsonProperty("charge-code")
	private String chargeCode;
	
	@JsonProperty("rate_basic")
	private String rateBasic;
	
	@JsonProperty("rate_basic_uom")
	private String rateBasicUom;
	
	@JsonProperty("rate_type")
	private String rateType;
	private Double rate;
	private String currency;
	
	@JsonProperty("base_rate")
	private Double baseRate;
	
	@JsonProperty("min_rate")
	private Double minRate;
	
	@JsonProperty("max_rate")
	private Double maxRate;
	
	@JsonProperty("breakpoint_flag")
	private Boolean breakpointFlag;
	
	@JsonProperty("consolidated_flag")
	private Boolean consolidatedFlag;
	
	@JsonProperty("discount_flag")
	private String discountFlag;
	
	@JsonProperty("primary_intermediate_airport")
	private String primaryIntermediateAirport;
	
	@JsonProperty("backup_intermediate_string")
	private String backupIntermediateString;
	
	@JsonProperty("private_sub_carrier")
	private String primarySubCarrier;
	
	@JsonProperty("backup_sub_carrier")
	private String backupSubCarrier;
	
	@JsonProperty("transit_type")
	private Integer transitTime;
	
	@JsonProperty("route_frequency")
	private String routeFrequency;
}
