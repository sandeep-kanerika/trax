package com.trax.ratemanager.ratetable.definition;

import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.column.defination.ColumnDefinition;

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
public class RateTableDefinitionVo {

	@Id
	private String id;
	private String creatorOrgId;
	private String name;

	private ZonedDateTime dateCreated;

	private String tableGroup;
	private String tableType;
	private String columnHash;
	private List<ColumnDefinition> columns;

}
