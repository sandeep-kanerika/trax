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
	public ResponseEntity<Object> createRateSets(@RequestBody RateSetVo rateSetVo) throws Exception {
		log.info("***************Create RateSet(PostRequest) ");
		log.info("***************RateSetValue Object:::" + rateSetVo);
		RateSet rateSet = RateSetConverter.convertToRateSet(rateSetVo);
		log.info("***************RateSet Object After VO--to-->BO:::" + rateSet);
		RateSet createdRateSet = null;
		try 
		{
			createdRateSet = rateSetsService.create(rateSet);
			return ResponseEntity.ok(createdRateSet);
		} catch (Exception ex) 
		{
			log.error("Error occured:::" + ex.getMessage());
		     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResourceNotFoundException("error",ex));
		}
	}

	@GetMapping(value = "/rate/sets/{id}")
	public ResponseEntity<RateSet> getRateSets(@PathVariable String id) {
		log.info("***************Retrive rateset by id:::" + id);
		HttpStatus status = HttpStatus.OK;
		RateSet retrivedRateSet = rateSetsService.getById(id);
		if(retrivedRateSet!= null)
		{
			return new ResponseEntity<RateSet>(retrivedRateSet,HttpStatus.OK);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping(value = "/rate/sets/all")
	public ResponseEntity<Object> findAllRateSets() {
		log.info("**************fetch all rateset objects");
		try {
			List<RateSet> allRateSets = rateSetsService.findAll();
			if (allRateSets != null && !allRateSets.isEmpty()) 
			{
				return ResponseEntity.ok(allRateSets);
			}
			else 
			{
				log.error("**********No object(s) found!!!");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}
		catch (Exception e) 
		{
			log.error("**********Error occured:::" + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping(value = "/rate/sets", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> updateRateSets(@RequestBody RateSetVo rateSetVo) throws Exception {
		log.info("***************updateRateSets invoked, internally its going to call post method only...");
		return createRateSets(rateSetVo);
	}

	@DeleteMapping(value = "/rate/sets/{id}")
	public ResponseEntity<RateSet> deleteRateSet(@PathVariable String id) {
		ResponseEntity<RateSet> responseEntity = null;
		log.info("**************deleteRateSets invoked with id:::" + id);
		RateSet rateSet = rateSetsService.getById(id);
		log.info("**************found the rateset id in DB:::" + rateSet);
		if (rateSet != null) 
		{
			try 
			{
				rateSetsService.delete(rateSet);
				log.info("deleted the ratesetid from database..." + rateSet.getId());
				return ResponseEntity.ok(rateSet);
			} catch (Exception ex) 
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
		} else 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
