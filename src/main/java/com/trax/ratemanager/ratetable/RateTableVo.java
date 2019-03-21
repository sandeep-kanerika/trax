package com.trax.ratemanager.ratetable;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.config.AppConstants;
import com.trax.ratemanager.ratecolumn.RateColumn;
import com.trax.ratemanager.raterow.RateRow;
import com.trax.ratemaneger.user.UserAuditor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RateTableVo {

	@Id
	private String id;
	private String creatorOrgId;
	private String tableName;

	private ZonedDateTime dateCreated;

	private String tableGroup;
	private String tableType;
	private String columnHash;
	private List<RateColumn> columns;
	private List<RateRow> rateRows;

}
