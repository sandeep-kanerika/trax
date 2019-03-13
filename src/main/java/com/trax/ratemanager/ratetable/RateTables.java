package com.trax.ratemanager.ratetable;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.config.AppConstants;
import com.trax.ratemanager.ratecolumn.RateColumn;
import com.trax.ratemanager.raterow.RateRows;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
public class RateTables {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String creatorOrgId;
	private String name;
	@JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
	private Timestamp dateCreated;
	private String tableGroup;
	private String tableType;
	private String columnHash;

	@OneToMany
	private List<RateColumn> columns;

	@OneToMany
	private List<RateRows> rateRows;

}
