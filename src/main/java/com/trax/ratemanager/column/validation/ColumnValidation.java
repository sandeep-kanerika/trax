package com.trax.ratemanager.column.validation;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.column.defination.RateColumnDefinition;
import com.trax.ratemanager.rateset.RateSet;
import com.trax.ratemanager.ratetable.RateTable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ColumnValidation {

	@Id
	private String id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "columnDefinitionId")
	private RateColumnDefinition columnDefinition;  // need to replace with RateColumn now.
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "rateSetId")
	private RateSet rateSet;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "tableId")
	private RateTable table;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)  // okay, the one to one  rel need to be impl
	@JoinColumn(name = "validationId")
	private Validation validation;
}
