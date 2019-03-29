package com.trax.ratemanager.orgnization;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trax.ratemanager.rateset.RateSet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Organization
{

	@Id
	private String id;
	private String orgName;
	private Enum<OrganizationType> orgType;

	@JsonIgnoreProperties("buyerOrg")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "buyerOrg")
	List<RateSet> buyer;

	@JsonIgnoreProperties("sellerOrg")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sellerOrg")
	List<RateSet> seller;

	public Organization(String id, String orgName, Enum<OrganizationType> orgType)
	{
		super();
		this.id = id;
		this.orgName = orgName;
		// this.orgType = orgType;
	}

}
