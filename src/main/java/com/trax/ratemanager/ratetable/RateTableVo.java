package com.trax.ratemanager.ratetable;

import java.time.ZonedDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trax.ratemanager.ratecolumn.RateColumnVo;
import com.trax.ratemanager.raterow.RateRowVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RateTableVo
{
	private String id;
	@JsonProperty("creator_org_id")
	private String creatorOrgId;
	
	@JsonProperty("rate_set_id")
	private String rateSetId;
	
	private String name;
	
	@JsonProperty("date_created")
	private ZonedDateTime dateCreated;
	
	@JsonProperty("table_group")
	private String tableGroup;
	
	@JsonProperty("table_type")
	private String tableType;
	
	@JsonProperty("column_hash")
	private String columnHash;
	
	private List<RateColumnVo> columns;
	
	private List<RateRowVo> rateRows;
}
