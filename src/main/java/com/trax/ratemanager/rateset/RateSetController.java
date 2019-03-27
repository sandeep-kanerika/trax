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
import com.trax.ratemanager.column.defination.ColumnDefinition;
import com.trax.ratemanager.column.defination.ColumnDefinitionConverter;
import com.trax.ratemanager.column.defination.ColumnDefinitionService;
import com.trax.ratemanager.column.defination.ColumnDefinitionVo;
import com.trax.ratemanager.exception.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RateSetController {

	@Autowired
	private RateSetsService rateSetsService;

	@Autowired
	private ColumnDefinitionService columnDefService;

	@PostMapping(value = "/rate-sets", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> createRateSets(@RequestBody RateSetVo rateSetVo) throws Exception {
		log.info("***************Create RateSet(PostRequest) ");
		log.info("***************RateSetValue Object ::::" + rateSetVo);
		RateSet rateSet = RateSetConverter.convertToRateSet(rateSetVo);
		log.info("***************RateSet Object After VO--to-->BO ::::" + rateSet);
		RateSet createdRateSet = null;
		try {
			createdRateSet = rateSetsService.create(rateSet);
			return ResponseEntity.ok(createdRateSet);
		} catch (Exception ex) {
			log.error("Error occured ::::" + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResourceNotFoundException("error", ex));
		}
	}

	// can be removed
	@PostMapping(value = "/rates/active/{rateSetId}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> viewActiveRates(@PathVariable String rateSetId, @RequestParam("org") String orgId)
			throws Exception {
		log.info("***************View Active Rate(PostRequest) ");
		log.info("***************RateSet :::: " + rateSetId + " :::: OrgId ::::" + orgId);

		return ResponseEntity.ok("");
	}

	@PostMapping(value = "/rates/submit/{rateSetId}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> operationsActiveRates(@PathVariable String rateSetId,
			@RequestParam("amendmentType") String amendmentType, @RequestParam("org") String orgId) throws Exception {
		log.info("***************add Active Rate(PostRequest) ");
		log.info("***************RateSet :::: " + rateSetId + " :::: amendmentType :::: " + amendmentType
				+ " :::: OrgId :::: " + orgId);
		return ResponseEntity.ok("");
	}

	@GetMapping(value = { "/rates/active/{rateSetId}", "/rate-sets/{rateSetId}" })
	public ResponseEntity<RateSet> getRateSets(@PathVariable String rateSetId, @RequestParam("org") String orgId) {
		log.info("*************** Get Rate Set by id ::::" + rateSetId);
		RateSet retrivedRateSet = rateSetsService.getById(rateSetId);
		if (retrivedRateSet != null) {
			return new ResponseEntity<RateSet>(retrivedRateSet, HttpStatus.OK);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// find all rate sets
	@GetMapping(value = { "/rates/active", "/rate-sets/" })
	public ResponseEntity<Object> findAllRateSets(@RequestParam("org") String orgId) {
		log.info("**************fetch all rate Set objects");
		try {
			List<RateSet> allRateSets = rateSetsService.findAll();
			if (allRateSets != null && !allRateSets.isEmpty()) {
				return ResponseEntity.ok(allRateSets);
			} else {
				log.error("**********No object(s) found!!!");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			log.error("**********Error occured:::" + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

// impl meta
	@PutMapping(value = "/rate-sets", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> updateRateSets(@RequestBody RateSetVo rateSetVo) throws Exception {
		log.info("***************Update Rate Sets , internally its going to call post method only...");
		return createRateSets(rateSetVo);
	}

	@DeleteMapping(value = "/rate-sets/{id}")
	public ResponseEntity<RateSet> deleteRateSet(@PathVariable String id) {
		log.info("**************Delete RateSets invoked with id ::::" + id);
		RateSet rateSet = rateSetsService.getById(id);
		log.info("**************found the rateset id in DB ::::" + rateSet);
		if (rateSet != null) {
			try {
				rateSetsService.delete(rateSet);
				log.info("Deleted the ratesetid from database ::::" + rateSet.getId());
				return ResponseEntity.ok(rateSet);
			} catch (Exception ex) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping(value = "/rate-sets/{rateSetId}/row-validations")
	public Boolean getRateSetForRowValidation(@PathVariable String rateSetId) {
		return false;
	}

	@GetMapping(value = "/rate-sets/{rateSetId}/rates-summary")
	public Boolean getRateSetSummary(@PathVariable String rateSetId) {
		return false;
	}

	@PostMapping(value = "/rate-sets/{id}/save-as-draft", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Boolean saveRateSetAsDraft(@PathVariable String id, @RequestBody AmendmentVo amendmentVo) {
		return false;
	}

	@PostMapping(value = "/rate-sets/{id}/submit-for-approval", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Boolean submitRateSetForApproval(@PathVariable String id, @RequestBody AmendmentVo amendmentVo) {
		return false;
	}

	@PostMapping(value = "/rate-sets/{id}/approve-rates", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Boolean approveRateSet(@PathVariable String id, @RequestBody AmendmentVo amendmentVo) {
		return false;
	}

	@PostMapping(value = "/rate-sets/{id}/reject-rates", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Boolean rejectTheRateSet(@PathVariable String id, @RequestBody AmendmentVo amendmentVo) {
		return false;
	}

	@GetMapping(value = "/rate-sets/{rateSetId}/{tableId}/columns/{columnDefinitionId}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ColumnDefinitionVo getColumnDefByI(@PathVariable String rateSetId, @PathVariable String tableId,
			@PathVariable String columnDefinitionId) {
		ColumnDefinition rateColumnDefinition = columnDefService.getById(columnDefinitionId);
		ColumnDefinitionVo colDefVo = ColumnDefinitionConverter.convertToRateSetVo(rateColumnDefinition);
		return colDefVo;
	}
	
	@PostMapping(value = "/rate-sets/{rateSetId}/{tableId}/columns/{columnDefinitionId}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ColumnDefinitionVo updateColDefById(@PathVariable String rateSetId, @PathVariable String tableId,
			@PathVariable String columnDefinitionId) 
	{    // valid values??
		 // is required??
		
		ColumnDefinition rateColumnDefinition = columnDefService.getById(columnDefinitionId);
		ColumnDefinitionVo colDefVo = ColumnDefinitionConverter.convertToRateSetVo(rateColumnDefinition);
		return colDefVo;
	}
	
	
	
	@PostMapping(value = "/rate-sets/{rateSetId}/{upload}", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ColumnDefinitionVo uploadRateSet(@RequestBody AmendmentVo amendmentVo) 
	{   		
		// upload the file and create amendment/rateset
		return null;
	}
	
	@PostMapping(value = "/rate-sets/{id}/{assign-approvers}", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ColumnDefinitionVo uploadRateSet(@PathVariable String rateSetId,@PathVariable(name="assign-approvers") String assignApprover ) 
	{   		
		// upload the file and create amendment/rateset
		return null;
	}
	
	
	
	


}
