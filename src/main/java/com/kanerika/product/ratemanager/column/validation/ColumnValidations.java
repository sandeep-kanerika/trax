package com.kanerika.product.ratemanager.column.validation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

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
public class ColumnValidations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String tableId;

	private String columnDefinitionId;

	private String rateSetId;
	
	private String validation;

}
