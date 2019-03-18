package com.trax.ratemanager.ratecolumn;

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

@RestController("/column/validations")
@Slf4j
public class RateColumnController {

	@Autowired
	RateColumnService rateColumnService;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<RateColumn> createRateColumn(@RequestBody RateColumn rateColumn) {

		log.info("add ratecolumn invoked");
		return new ResponseEntity<RateColumn>(rateColumnService.create(rateColumn), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RateColumn> getRateColumn(@PathVariable String id) {
		log.info("getRateColumn invoked");
		HttpStatus returnStatus = HttpStatus.OK;
		try {
			RateColumn rateColumn = rateColumnService.getById(id);
			if (rateColumn != null) {
				return new ResponseEntity<>(rateColumn, returnStatus);
			} else {
				throw new ResourceNotFoundException("RateColumn Id doesn't exist !");
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

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<RateColumn> updateRateColumn(@RequestBody RateColumn rateColumn) {

		log.info("update rate column invoked");
		return new ResponseEntity<RateColumn>(rateColumnService.update(rateColumn), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<RateColumn> deleteColumnValidations(@PathVariable String id) {

		log.info("delete rate column invoked");
		rateColumnService.getRepository().deleteById(id);
		return new ResponseEntity<RateColumn>(HttpStatus.OK);
	}

}
