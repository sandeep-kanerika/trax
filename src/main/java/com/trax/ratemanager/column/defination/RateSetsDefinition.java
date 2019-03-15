package com.trax.ratemanager.column.defination;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.trax.ratemanager.config.AppConstants;

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
public class RateSetsDefinition {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private Integer status;
    
	private Long creatorOrgId;
	
	private String region;
	
	private String mode;
	
	private String Name;
    
    private Timestamp dateCreated;

    private Timestamp dateUpdated;

    private String tableHash;
    
    private String tables;
}
