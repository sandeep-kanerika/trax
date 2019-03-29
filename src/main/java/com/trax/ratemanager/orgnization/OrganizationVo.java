package com.trax.ratemanager.orgnization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrganizationVo
{
	private String id;
	private String orgName;
	private Enum<OrganizationType> orgType;

}
