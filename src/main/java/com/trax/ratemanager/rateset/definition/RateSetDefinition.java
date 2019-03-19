package com.trax.ratemanager.rateset.definition;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.ratetable.definition.RateTableDefinition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RateSetDefinition {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private Integer status;

	private Long creatorOrgId;

	private String region;

	private String mode;

	private String name;

	private Timestamp dateCreated;

	private Timestamp dateUpdated;

	private String tableHash;

	@OneToMany
	private List<RateTableDefinition> tables;
}
