package com.trax.ratemanager.ratetable.definition;

import java.time.ZonedDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.column.defination.RateColumnDefinition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class RateTableDefinitionVo
{
	private String id;
	private String creatorOrgId;
	private String name;
	private String rateSetDefinitionId;
	private ZonedDateTime dateCreated;
	private String tableGroup;
	private String tableType;
	private String columnHash;
	private List<RateColumnDefinition> columns;

}
