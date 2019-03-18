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
import org.springframework.web.bind.annotation.RestController;

import com.trax.ratemanager.exception.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RateSetController {
	@Autowired
	RateSetsService rateSetsService;

	private HttpStatus returnStatus = HttpStatus.OK;

	@PostMapping(value = "/rate/sets", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<RateSet> createRateSets(@RequestBody RateSetVo rateSetVo) throws Exception {
		log.info("***************Create RateSet(PostRequest) ");
		log.info("***************RateSetValue Object:::" + rateSetVo);
		RateSet rateSet = RateSetConverter.convertToRateSet(rateSetVo);
		log.info("***************RateSet Object After VO--to-->BO:::" + rateSet);
		RateSet createdRateSet = null;
		try {
			createdRateSet = createdRateSet = rateSetsService.create(rateSet);
			returnStatus = HttpStatus.CREATED;
		} catch (Exception ex) {
			log.error("Error occured:::" + ex.getMessage());
			returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity(createdRateSet, returnStatus);
	}

	@GetMapping(value = "/rate/sets/{id}")
	public RateSet getRateSets(@PathVariable String id) {
		log.info("***************Retrive rateset by id:::" + id);

		RateSet retrivedRateSet = rateSetsService.getById(id);
		return retrivedRateSet;
	
		/*
		 * try { RateSet retrivedRateSet = rateSetsService.getById(id); if
		 * (retrivedRateSet != null) { return new
		 * ResponseEntity<RateSet>(retrivedRateSet,HttpStatus.OK ); } else {
		 * returnStatus = HttpStatus.NOT_FOUND; throw new
		 * ResourceNotFoundException("RateSets Id doesn't exist !"); } } catch
		 * (ResourceNotFoundException e) {
		 * log.error("************Error occured:::"+e.getMessage()); returnStatus =
		 * HttpStatus.NOT_FOUND; } catch (Exception e) { returnStatus =
		 * HttpStatus.INTERNAL_SERVER_ERROR;
		 * log.error("***********Error occured:::"+e.getMessage()); } return new
		 * ResponseEntity<RateSet>(returnStatus);
		 */
		}

	@GetMapping(value = "/rate/sets/all")
	public ResponseEntity<List<RateSet>> findAllRateSets() {
		log.info("**************fetch all rateset objects");
		try {
			List<RateSet> allRateSets = rateSetsService.findAll();
			if (allRateSets != null && !allRateSets.isEmpty()) {
				return new ResponseEntity<List<RateSet>>(allRateSets, HttpStatus.OK);
			} else {
				log.error("**********No object(s) found!!!");
				returnStatus = HttpStatus.NOT_FOUND;
				// throw new ResourceNotFoundException("RateSets Id doesn't exist !");
			}

		} catch (ResourceNotFoundException e) {
			log.error("**********Error occured:::" + e.getMessage());
			returnStatus = HttpStatus.NOT_FOUND;
		} catch (Exception e) {
			log.error("**********Error occured:::" + e.getMessage());
			returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<RateSet>>(returnStatus);
	}

	@PutMapping(value = "/rate/sets", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<RateSet> updateRateSets(@RequestBody RateSetVo rateSetVo) throws Exception {
		log.info("***************updateRateSets invoked, internally its going to call post method only...");
		return createRateSets(rateSetVo);
	}

	@DeleteMapping(value = "/rate/sets/{id}")
	public ResponseEntity<RateSet> deleteRateSet(@PathVariable String id) {
		ResponseEntity<RateSet> responseEntity = null;
		log.info("**************deleteRateSets invoked with id:::" + id);
		RateSet rateSet = rateSetsService.getById(id);
		log.info("**************found the rateset id in DB:::" + rateSet);
		if (rateSet != null) {
			try {
				rateSetsService.delete(rateSet);
				log.info("deleted the ratesetid from database..." + rateSet.getId());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			responseEntity = new ResponseEntity<RateSet>(rateSet, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<RateSet>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

}
