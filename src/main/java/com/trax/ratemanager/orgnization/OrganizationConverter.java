package com.trax.ratemanager.orgnization;

import com.trax.ratemaneger.utility.UUIDGenerator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrganizationConverter {

	public static Organization convertToOrganization(OrganizationVo orgVo) throws Exception {

		Organization org = null;
		if (orgVo != null) {
			org = new Organization();
			log.info("***************existing id in convertor ::::" + orgVo.getId());
			 String id = orgVo.getId();
			 if(id==null)
			 {
				 id= UUIDGenerator.generateUUID().toString();
				 orgVo.setId(id);
			 }
			 
			org.setId(orgVo.getId());
			log.info("***************Column Validation Object in Amendment Convert:::" + org);
			return org;
		} else {
			throw new Exception("Problem with input");
		}
	}

	public static OrganizationVo convertToOrganizationVo(Organization org) throws Exception {
		
		OrganizationVo orgVo = new OrganizationVo();
		
		if(org != null)
		{
			orgVo.setId(org.getId());
			
			// add remaining fields and remove this comment.
		}
		
		return orgVo;
	}
}
