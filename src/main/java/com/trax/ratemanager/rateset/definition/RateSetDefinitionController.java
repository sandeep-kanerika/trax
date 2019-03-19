package com.trax.ratemanager.rateset.definition;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@RestController
@RequestMapping("/rate/sets/definition")
public class RateSetDefinitionController {
	
	@Autowired
	RateSetDefinitionService rateSetsDefinitionSer;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RateSetDefinitionController.class);

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public RateSetDefinition createRateSetsDefinition(@RequestBody RateSetDefinition rateSetsDefinition) {
		LOGGER.info("addRateSetsDefinition invoked");
		return rateSetsDefinitionSer.create(rateSetsDefinition);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RateSetDefinition> getRateSetsDefinition(@PathVariable String id) {
		LOGGER.info("getRateSetsDefinition invoked");
		HttpStatus returnStatus = HttpStatus.OK;
		try {
			RateSetDefinition getRateSetsDefinitionDetail = rateSetsDefinitionSer.getById(id);
			if (getRateSetsDefinitionDetail != null) {
				return new ResponseEntity<>(getRateSetsDefinitionDetail, returnStatus);
			} else {
				throw new ResourceNotFoundException("RateSetsDefinition Id doesn't exist !");
			}
		} catch (ResourceNotFoundException e) {
			LOGGER.error(e.getMessage());
			returnStatus = HttpStatus.NOT_FOUND;
		} catch (Exception e) {
			returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			LOGGER.error(e.getMessage());
		}
		return new ResponseEntity<>(returnStatus);
	}
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH})
	public RateSetDefinition updateRateSetsDefinition(@RequestBody RateSetDefinition rateSetsDefinition) {

		LOGGER.info("updateRateSetsDefinition invoked");
		return rateSetsDefinitionSer.update(rateSetsDefinition);
	}

	@DeleteMapping(value = "/{id}")
	public RateSetDefinition deleteRateSetsDefinition(@PathVariable String id) {

		LOGGER.info("deleteRateSetsDefinition invoked");
		return null/* RateSetsSer.delete(id) */;
	}
}
