package com.trax.ratemanager.ratetable.definition;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.column.defination.RateColumnDefinition;
import com.trax.ratemanager.config.AppConstants;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
public class RateTableDefinition {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private Long creatorOrgId;
	private String name;
	
	@JsonFormat(pattern = AppConstants.DEFAULT_ZONED_DATETIME_FORMAT)
	private ZonedDateTime dateCreated;
	
	private String tableGroup;
	private String tableType;
	private String columnHash;

	@OneToMany
	@JoinColumn(name="rateTableDefinitionId")
	private List<RateColumnDefinition> columns;

}
