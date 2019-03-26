package com.trax.ratemanager.ratetable;

import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.ratecolumn.RateColumnVo;
import com.trax.ratemanager.raterow.RateRow;

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
public class RateTableVo {

	@Id
	private String id;
	private String creatorOrgId;
	private String name;

	private ZonedDateTime dateCreated;

	private String tableGroup;
	private String tableType;
	private String columnHash;
	private List<RateColumnVo> columns;
	private List<RateRow> rateRows;

}
