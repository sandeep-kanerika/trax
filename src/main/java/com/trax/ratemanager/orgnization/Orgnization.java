package com.trax.ratemanager.orgnization;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orgnization {

	@Id
	private String id;
	private String orgName;
	private Enum<OrganizationType> orgType;

}