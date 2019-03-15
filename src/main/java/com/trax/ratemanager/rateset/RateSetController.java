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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trax.ratemanager.exception.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

@RestController("/rate/sets")
@Slf4j
public class RateSetController {
	

	@Autowired
	RateSetsService rateSetsSer;
	
	private HttpStatus returnStatus = null;
	private ResponseEntity<RateSet> response = null;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<RateSet> createRateSets(@RequestBody RateSetVo rateSetVo) throws Exception {
		log.info("***************addRateSets invokedaddRateSets invoked with ratesetvo**********************"+rateSetVo);
		RateSet rateSet = RateSetConverter.convertToRateSet(rateSetVo);
		log.info("\n******************RateSet Info*******************" + rateSet);
		RateSet createdRateSet = null;
		try {
		    createdRateSet = createdRateSet = rateSetsSer.create(rateSet);
		    returnStatus=HttpStatus.CREATED;
		}
		catch(Exception ex) {
			log.error(ex.getMessage());
			returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity(createdRateSet,returnStatus);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RateSet> getRateSets(@PathVariable String id) {
		log.info("getRateSets invoked");
		HttpStatus returnStatus = HttpStatus.OK;
		try {
			RateSet getAmendmentsDetail = rateSetsSer.getById(id);
			if (getAmendmentsDetail != null) {
				return new ResponseEntity<RateSet>(getAmendmentsDetail, returnStatus);
			} else {
				throw new ResourceNotFoundException("RateSets Id doesn't exist !");
			}
		} catch (ResourceNotFoundException e) {
			log.error(e.getMessage());
			returnStatus = HttpStatus.NOT_FOUND;
		} catch (Exception e) {
			returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			log.error(e.getMessage());
		}
		return new ResponseEntity<RateSet>(returnStatus);
	}

	@GetMapping
	public ResponseEntity<List<RateSet>> findAllRateSets() {
		log.info("getRateSets invoked");
		HttpStatus returnStatus = HttpStatus.OK;
		try {
			List<RateSet> allRateSets = rateSetsSer.findAll();
			if (allRateSets != null && !allRateSets.isEmpty()) {
				return new ResponseEntity<List<RateSet>>(allRateSets, returnStatus);
			} else {
				throw new ResourceNotFoundException("RateSets Id doesn't exist !");
			}
		} catch (ResourceNotFoundException e) {
			log.error(e.getMessage());
			returnStatus = HttpStatus.NOT_FOUND;
		} catch (Exception e) {
			returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			log.error(e.getMessage());
		}
		return new ResponseEntity<List<RateSet>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<RateSet> updateRateSets(@RequestBody RateSetVo rateSetVo) throws Exception {
		log.info("updateRateSets invoked");
		return createRateSets(rateSetVo);
	}

	@PutMapping()
	public ResponseEntity<RateSet> updateRateSets(@PathVariable String id) {
		ResponseEntity<RateSet> responseEntity = null;
		log.info("deleteRateSets invoked");
		RateSet rateSet = rateSetsSer.getById(id);
		if (rateSet != null) {
			rateSetsSer.delete(rateSet);
			log.info("deleted the ratesetid from database..." + rateSet.getId());
			responseEntity = new ResponseEntity<RateSet>(rateSet, HttpStatus.OK);
		}
		return responseEntity;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<RateSet> deleteRateSets(@PathVariable String id) {
		ResponseEntity<RateSet> responseEntity = null;
		log.info("deleteRateSets invoked");
		RateSet rateSet = rateSetsSer.getById(id);
		if (rateSet != null) {
			rateSetsSer.delete(rateSet);
			log.info("deleted the ratesetid from database..." + rateSet.getId());
			responseEntity = new ResponseEntity<RateSet>(rateSet, HttpStatus.OK);
		}
		return responseEntity;
	}

}
