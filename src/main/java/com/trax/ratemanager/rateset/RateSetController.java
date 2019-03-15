package com.trax.ratemanager.rateset;

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
@RequestMapping("/rate/sets")
public class RateSetController {
	
	@Autowired
	RateSetsService rateSetsSer;
	

	private static final Logger LOGGER = LoggerFactory.getLogger(RateSetController.class);

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public RateSet createRateSets(@RequestBody RateSetVo rateSetVo) throws Exception {
		LOGGER.info("addRateSets invoked*************************************");
	    RateSet rateSet = RateSetConverter.convertToRateSet(rateSetVo);
		return rateSetsSer.create(rateSet);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RateSet> getRateSets(@PathVariable String id) {
		LOGGER.info("getRateSets invoked");
		HttpStatus returnStatus = HttpStatus.OK;
		try {
			RateSet getAmendmentsDetail = rateSetsSer.getById(id);
			if (getAmendmentsDetail != null) {
				return new ResponseEntity<>(getAmendmentsDetail, returnStatus);
			} else {
				throw new ResourceNotFoundException("RateSets Id doesn't exist !");
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
	public RateSet updateRateSets(@RequestBody RateSet rateSets) {

		LOGGER.info("updateRateSets invoked");
		return rateSetsSer.update(rateSets);
	}

	@DeleteMapping(value = "/{id}")
	public RateSet deleteRateSets(@PathVariable String id) {

		LOGGER.info("deleteRateSets invoked");
		return null/* RateSetsSer.delete(id) */;
	}

}
