package com.trax.ratemanager.column.defination;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.column.validation.ColumnValidation;

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
public class ColumnDefinition {

	@Id
	private String id;
	private String columnDefinitionId;
	private String ratesetId;
	private String tableId;

	@OneToOne
	private ColumnValidation columnValidation;
}
