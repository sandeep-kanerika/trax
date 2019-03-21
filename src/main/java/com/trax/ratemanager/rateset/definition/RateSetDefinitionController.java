package com.trax.ratemanager.rateset.definition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trax.ratemanager.exception.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/rate-sets-definitions")
public class RateSetDefinitionController {
	
	@Autowired
	RateSetDefinitionService rateSetsDefinitionSer;
	
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Object> createRateSetsDefinition(@RequestBody RateSetDefinitionVo rateSetsDefinitionVo) throws Exception {
		
		log.info("***************Create RateSetDefinition(PostRequest) ");
		log.info("***************RateSetDefinitionValue Object:::" + rateSetsDefinitionVo);
		RateSetDefinition rateSetDefinition = RateSetDefinitionConverter.convertToRateSetDefinition(rateSetsDefinitionVo);
		log.info("***************RateSetDefinition Object After VO--to-->BO:::" + rateSetDefinition);
		RateSetDefinition createdRateSetDefinition = null;
		try 
		{
			createdRateSetDefinition = rateSetsDefinitionSer.create(rateSetDefinition);
			return ResponseEntity.ok(createdRateSetDefinition);
		} catch (Exception ex) 
		{
			log.error("Error occured:::" + ex.getMessage());
		     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResourceNotFoundException("error",ex));
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<RateSetDefinition> getRateSetsDefinition(@PathVariable String id) {
		log.info("getRateSetsDefinition invoked");
		HttpStatus returnStatus = HttpStatus.OK;
		try {
			RateSetDefinition getRateSetsDefinitionDetail = rateSetsDefinitionSer.getById(id);
			if (getRateSetsDefinitionDetail != null) {
				return new ResponseEntity<>(getRateSetsDefinitionDetail, returnStatus);
			} else {
				throw new ResourceNotFoundException("RateSetsDefinition Id doesn't exist !");
			}
		} catch (ResourceNotFoundException e) {
			log.error(e.getMessage());
			returnStatus = HttpStatus.NOT_FOUND;
		} catch (Exception e) {
			returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			log.error(e.getMessage());
		}
		return new ResponseEntity<>(returnStatus);
	}
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH})
	public RateSetDefinition updateRateSetsDefinition(@RequestBody RateSetDefinition rateSetsDefinition) {

		log.info("updateRateSetsDefinition invoked");
		return rateSetsDefinitionSer.update(rateSetsDefinition);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<RateSetDefinition> deleteRateSetsDefinition(@PathVariable String id) {

		ResponseEntity<RateSetDefinition> responseEntity = null;
		log.info("**************deleteRateSetDefinition invoked with id:::" + id);
		RateSetDefinition rateSetDefinition = rateSetsDefinitionSer.getById(id);
		log.info("**************found the RateSetDefinition id in DB:::" + rateSetDefinition);
		if (rateSetDefinition != null) 
		{
			try 
			{
				rateSetsDefinitionSer.delete(rateSetDefinition);
				log.info("deleted the ratesetid from database..." + rateSetDefinition.getId());
				return ResponseEntity.ok(rateSetDefinition);
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
