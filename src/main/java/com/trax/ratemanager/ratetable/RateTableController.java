package com.trax.ratemanager.ratetable;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trax.ratemanager.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/rate/tables")
public class RateTableController {

	@Autowired
	RateTableService rateTablesService;

	private static final Logger LOGGER = LoggerFactory.getLogger(RateTableController.class);

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public RateTable createRateTablesDefinition(@RequestBody RateTable rateTable) {

		LOGGER.info("rateTablesDefinition invoked");
		return rateTablesService.create(rateTable);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RateTable> getRateTablesDefinition(@PathVariable String id) {
		LOGGER.info("getRateTablesDefinition invoked");
		HttpStatus returnStatus = HttpStatus.OK;
		try {
			RateTable getAmendmentsDetail = rateTablesService.getById(id);

			if (getAmendmentsDetail != null) {
				return new ResponseEntity<>(getAmendmentsDetail, returnStatus);
			} else {
				throw new ResourceNotFoundException("RateTableDefinition Id doesn't exist !");
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

	@RequestMapping(method = { RequestMethod.PUT, RequestMethod.PATCH })
	public RateTable updateRateTablesDefinition(@RequestBody RateTable rateTablesDefinition) {

		LOGGER.info("updateRateTablesDefinition invoked");
		return rateTablesService.update(rateTablesDefinition);
	}

	/*
	 * @DeleteMapping(value = "/{id}") public RateTable
	 * deleteRateTablesDefinition(@PathVariable String id) {
	 * 
	 * LOGGER.info("deleteRateTable invoked"); return
	 * rateTableService.delete(getRateTable(id)); }
	 */

}
