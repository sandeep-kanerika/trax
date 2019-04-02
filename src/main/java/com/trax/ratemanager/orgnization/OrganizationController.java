package com.trax.ratemanager.orgnization;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OrganizationController
{

	@Autowired
	private OrganizationService organizationService;

	@PostMapping(value = "/organization", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Organization createOrganization(@RequestBody OrganizationVo orgVo) throws Exception
	{
		log.info("***************Create Add org (PostRequest) ::::");
		log.info("***************Org VO Object:::" + orgVo);
		Organization org = OrganizationConverter.convertToOrganization(orgVo);
		return organizationService.create(org);
	}

	@GetMapping(value = "/organization", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Organization> getAllOrganizations() throws Exception
	{
		log.info("***************Create ALL ORGS get method::::");
		return organizationService.findAll();
	}

	@GetMapping(value = "/organization/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Organization getAnOrgById(@PathVariable String id) throws Exception
	{
		log.info("***************Create ALL ORGS get method::::");
		return organizationService.getById(id);
	}

	@PutMapping(value = "/organization", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Organization updateOrgnization(@RequestBody OrganizationVo orgVo) throws Exception
	{
		log.info("***************Create Add org (PostRequest) ::::");
		log.info("***************Column Validations Object:::" + orgVo);
		Organization org = OrganizationConverter.convertToOrganization(orgVo);
		return organizationService.update(org);
	}

	@DeleteMapping(value = "/organization/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Boolean deleteOrg(@PathVariable String id) throws Exception
	{
		log.info("***************Delete org by id ::::" + id);
		try
		{
			organizationService.delete(id);
		}
		catch (Exception ex)
		{
			log.error("some expe occcured:::" + ex.getMessage());
			return false;
		}
		return true;
	}

}
