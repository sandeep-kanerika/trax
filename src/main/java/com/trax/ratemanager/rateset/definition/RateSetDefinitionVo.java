package com.trax.ratemanager.rateset.definition;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.config.AppConstants;
import com.trax.ratemanager.ratetable.definition.RateTableDefinition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RateSetDefinitionVo {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String status;

	private String creatorOrgId;

	private String region;

	private String mode;

	private String name;

	private ZonedDateTime dateCreated;

	private ZonedDateTime dateUpdated;

	private String tableHash;

	private List<RateTableDefinition> tables;
}
