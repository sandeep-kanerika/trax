package com.trax.ratemanager.rateset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trax.ratemanager.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/downloads/rate-sets")
public class RateSetDownloadController {

	@Autowired
	RateSetsService rateSetsSer;

	private static final Logger LOGGER = LoggerFactory.getLogger(RateSetDownloadController.class);

	@GetMapping("/{id}")
	public  ResponseEntity< RateSet >  getRateSets(@PathVariable String id) {
		LOGGER.info("getRateSets invoked :::::-------------- " + id);
		HttpStatus returnStatus = HttpStatus.OK;
		
		try {
			RateSet getAmendmentsDetail = rateSetsSer.getById(id);
//			LOGGER.info("getAmendmentsDetail ::: " + getAmendmentsDetail.getBuyerOrg().getOrgName());
//			LOGGER.info("rateSet ::: " + rateSet);

			if (getAmendmentsDetail != null) {
				return  new ResponseEntity<>( getAmendmentsDetail , returnStatus) ;
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
	
	@GetMapping("/{id}/rate-tables/{tableId}")
	public  ResponseEntity< RateSet >  getRateSetsByTables(@PathVariable String id, @PathVariable String tableId) {
		LOGGER.info("getRateSets invoked :::::-------------- " + id);
		HttpStatus returnStatus = HttpStatus.OK;
		
		try {
			RateSet getAmendmentsDetail = rateSetsSer.getById(id);
			
//			LOGGER.info("getAmendmentsDetail ::: " + getAmendmentsDetail.getBuyerOrg().getOrgName());
//			LOGGER.info("rateSet ::: " + rateSet);

			if (getAmendmentsDetail != null) {
				return  new ResponseEntity<>( getAmendmentsDetail , returnStatus) ;
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
}
