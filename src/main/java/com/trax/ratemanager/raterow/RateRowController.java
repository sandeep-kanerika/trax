package com.trax.ratemanager.raterow;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trax.ratemanager.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/rate/rows")
public class RateRowController {
	
	@Autowired
	RateRowService rateRowsService;

	private static final Logger LOGGER = LoggerFactory.getLogger(RateRowController.class);

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	public RateRow createRateRows(@RequestBody RateRow rateRows) {

		LOGGER.info("addRateRows invoked---------------------->>>>>");
		return rateRowsService.create(rateRows);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RateRow> getRateRows(@PathVariable String id) {
		LOGGER.info("getRateRows invoked");
		HttpStatus returnStatus = HttpStatus.OK;
		try {
			RateRow getAmendmentsDetail = rateRowsService.getById(id);
			if (getAmendmentsDetail != null) {
				return new ResponseEntity<>(getAmendmentsDetail, returnStatus);
			} else {
				throw new ResourceNotFoundException("RateRows Id doesn't exist !");
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
	
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	public RateRow updateRateRows(@RequestBody RateRow rateRows) {

		LOGGER.info("updateRateRows invoked");
		return rateRowsService.update(rateRows);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteRateRows(@PathVariable String id) {

		LOGGER.info("deleteRateRows invoked");
		rateRowsService.delete(id);
	}

}