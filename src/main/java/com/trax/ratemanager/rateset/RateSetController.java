package com.trax.ratemanager.rateset;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trax.ratemanager.amendment.AmendmentVo;
import com.trax.ratemanager.column.defination.RateColumnDefinition;
import com.trax.ratemanager.column.defination.RateColumnDefinitionConverter;
import com.trax.ratemanager.column.defination.RateColumnDefinitionService;
import com.trax.ratemanager.column.defination.RateColumnDefinitionVo;
import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.orgnization.OrganizationService;
import com.trax.ratemanager.ratetable.RateTableService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RateSetController
{

	@Autowired(required = true)
	private RateSetsService rateSetsService;

	@Autowired(required = true)
	private RateColumnDefinitionService columnDefService;

	@Autowired(required = true)
	private OrganizationService organizationService;
	
	@Autowired(required = true)
	private RateSetsService rateSetService;
	
	@Autowired(required = true)
	private RateTableService rateTableService;

	@PostMapping(value = "/rate-sets", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> createRateSets(@RequestBody RateSetVo rateSetVo) throws Exception
	{
		log.info("***************Create RateSet(PostRequest) ");
		log.info("***************RateSetValue Object ::::" + rateSetVo);
		RateSetConverter rateSetConverter = new RateSetConverter();

		RateSet rateSet = rateSetConverter.convertToRateSet(rateSetVo, organizationService, rateTableService);
		log.info("***************RateSet Object After VO--to-->BO ::::" + rateSet);
		RateSet createdRateSet = null;
		try
		{
			createdRateSet = rateSetsService.create(rateSet);
			return ResponseEntity.ok(createdRateSet);
		}
		catch (Exception ex)
		{
			log.error("Error occured ::::" + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResourceNotFoundException("error", ex));
		}
	}

	@PostMapping(value = "/rates/submit/{rateSetId}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> operationsActiveRates(@PathVariable String rateSetId, @RequestParam("amendmentType") String amendmentType, @RequestParam("org") String orgId)
			throws Exception
	{
		log.info("***************add Active Rate(PostRequest) ");
		log.info("***************RateSet :::: " + rateSetId + " :::: amendmentType :::: " + amendmentType + " :::: OrgId :::: " + orgId);
		return ResponseEntity.ok("");
	}

	@GetMapping(value = {"/rates/active/{rateSetId}", "/rate-sets/{rateSetId}"})
	public ResponseEntity<RateSet> getRateSets(@PathVariable String rateSetId, @RequestParam(value = "org", required = false) String org)
	{
		log.info("*************** Get Rate Set by id ::::" + rateSetId);
		RateSet retrivedRateSet = rateSetsService.getById(rateSetId);
		if (retrivedRateSet != null)
		{
			return new ResponseEntity<RateSet>(retrivedRateSet, HttpStatus.OK);
		}
		else
		{
			throw new ResourceNotFoundException("Rate Set is not found with " + rateSetId);
		}
	}

	// find all rate sets
	@GetMapping(value = {"/rates/active", "/rate-sets"})
	public ResponseEntity<Object> findAllRateSets(@RequestParam(value = "org", required = false) String orgId) throws Exception
	{
		log.info("**************fetch all rate Set objects");
		try
		{
			List<RateSet> allRateSets = rateSetsService.findAll();
			if (allRateSets != null && !allRateSets.isEmpty())
			{
				return ResponseEntity.ok(allRateSets);
			}
			else
			{
				log.error("**********No object(s) found!!!");
				throw new ResourceNotFoundException("No RateSet Found");
			}
		}
		catch (Exception e)
		{
			log.error("**********Error occured:::" + e.getMessage());
			throw new Exception("Problem occured while finding active rateset");
		}
	}

	@PutMapping(value = "/rate-sets", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> updateRateSets(@RequestBody RateSetVo rateSetVo) throws Exception
	{
		log.info("***************Update Rate Sets , internally its going to call post method only...");
		return createRateSets(rateSetVo);
	}

	@DeleteMapping(value = "/rate-sets/{id}")
	public ResponseEntity<String> deleteRateSet(@PathVariable String id) throws Exception
	{
		log.info("**************Delete RateSets invoked with id ::::" + id);
		RateSet rateSet = rateSetsService.getById(id);
		log.info("**************found the rateset id in DB ::::" + rateSet);
		if (rateSet != null)
		{
			try
			{
				rateSetsService.delete(rateSet);
				log.info("Deleted the ratesetid from database ::::" + rateSet.getId());
				return ResponseEntity.ok("Deleted RateSet Successfully: " + id);
			}
			catch (Exception ex)
			{
				throw new Exception("Error occured while deleting the RateSet " + id);
			}

		}
		else
		{
			throw new ResourceNotFoundException("RateSet with given ID is not present:" + id);
		}
	}

	@GetMapping(value = "/rate-sets/{rateSetId}/row-validations")
	public Boolean getRateSetForRowValidation(@PathVariable String rateSetId)
	{
		return false;
	}

	@GetMapping(value = "/rate-sets/{rateSetId}/rates-summary")
	public Boolean getRateSetSummary(@PathVariable String rateSetId)
	{
		return false;
	}

	@PostMapping(value = "/rate-sets/{id}/save-as-draft", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Boolean saveRateSetAsDraft(@PathVariable String id, @RequestBody AmendmentVo amendmentVo)
	{
		return false;
	}

	@PostMapping(value = "/rate-sets/{id}/submit-for-approval", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Boolean submitRateSetForApproval(@PathVariable String id, @RequestBody AmendmentVo amendmentVo)
	{
		return false;
	}

	@PostMapping(value = "/rate-sets/{id}/approve-rates", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Boolean approveRateSet(@PathVariable String id, @RequestBody AmendmentVo amendmentVo)
	{
		return false;
	}

	@PostMapping(value = "/rate-sets/{id}/reject-rates", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Boolean rejectTheRateSet(@PathVariable String id, @RequestBody AmendmentVo amendmentVo)
	{
		return false;
	}

	@GetMapping(value = "/rate-sets/{rateSetId}/{tableId}/columns/{columnDefinitionId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public RateColumnDefinitionVo getColumnDefByI(@PathVariable String rateSetId, @PathVariable String tableId, @PathVariable String columnDefinitionId)
	{
		RateColumnDefinition rateColumnDefinition = columnDefService.getById(columnDefinitionId);
		RateColumnDefinitionVo colDefVo = RateColumnDefinitionConverter.convertToRateSetVo(rateColumnDefinition);
		return colDefVo;
	}

	@PostMapping(value = "/rate-sets/{rateSetId}/{tableId}/columns/{columnDefinitionId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public RateColumnDefinitionVo updateColDefById(@PathVariable String rateSetId, @PathVariable String tableId, @PathVariable String columnDefinitionId)
	{ // valid values??
		// is required??

		RateColumnDefinition rateColumnDefinition = columnDefService.getById(columnDefinitionId);
		RateColumnDefinitionVo colDefVo = RateColumnDefinitionConverter.convertToRateSetVo(rateColumnDefinition);
		return colDefVo;
	}

	@PostMapping(value = "/rate-sets/{rateSetId}/{upload}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public RateColumnDefinitionVo uploadRateSet(@RequestBody AmendmentVo amendmentVo)
	{
		// upload the file and create amendment/rateset
		return null;
	}

	@PostMapping(value = "/rate-sets/{id}/{assign-approvers}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public RateColumnDefinitionVo uploadRateSet(@PathVariable String rateSetId, @PathVariable(name = "assign-approvers") String assignApprover)
	{
		// upload the file and create amendment/rateset
		return null;
	}

}
