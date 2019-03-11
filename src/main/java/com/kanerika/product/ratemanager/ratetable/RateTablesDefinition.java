package com.kanerika.product.ratemanager.ratetable;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.kanerika.product.ratemanager.column.definition.ColumnDefinitions;
import com.kanerika.product.ratemanager.config.AppConstants;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
public class RateTablesDefinition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
    private Long creatorOrgId;
    private String name;
    @JsonFormat(pattern = AppConstants.DEFAULT_DATETIME_FORMAT)
    private Timestamp dateCreated;
    private String tableGroup;
    private String tableType;
    private String columnHash;
    
    @OneToMany
    private List <ColumnDefinitions> columns;
    
}
