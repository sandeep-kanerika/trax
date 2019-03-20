package com.trax.ratemanager.orgnization;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trax.ratemanager.rateset.RateSet;
import com.trax.ratemanager.rateset.RateSetVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationVo {

	private String id;
	private String orgName;
	private Enum<OrganizationType> orgType;

	@JsonIgnoreProperties("buyerOrg")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "buyerOrg")
	List<RateSet> buyer;

	@JsonIgnoreProperties("sellerOrg")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sellerOrg")
	List<RateSetVo> seller;

	public OrganizationVo(String id, String orgName, Enum<OrganizationType> orgType) {
		super();
		this.id = id;
		this.orgName = orgName;
		// this.orgType = orgType;
	}

}
