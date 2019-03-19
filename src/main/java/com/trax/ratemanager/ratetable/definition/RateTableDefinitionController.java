package com.trax.ratemanager.ratetable.definition;

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

import jdk.nashorn.internal.runtime.FindProperty;

@RestController
@RequestMapping("/rate/tables/definition")
public class RateTableDefinitionController {

	@Autowired
	RateTableDefinitionService rateTablesDefinitionService;

	private static final Logger LOGGER = LoggerFactory.getLogger(RateTableDefinitionController.class);

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public RateTableDefinition createRateTablesDefinition(@RequestBody RateTableDefinition rateTablesDefinition) {

		LOGGER.info("rateTablesDefinition invoked");
		return rateTablesDefinitionService.create(rateTablesDefinition);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RateTableDefinition> getRateTablesDefinition(@PathVariable String id) {
		LOGGER.info("getRateTablesDefinition invoked");
		HttpStatus returnStatus = HttpStatus.OK;
		try {
			RateTableDefinition getAmendmentsDetail = rateTablesDefinitionService.getById(id);

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
	public RateTableDefinition updateRateTablesDefinition(@RequestBody RateTableDefinition rateTablesDefinition) {

		LOGGER.info("updateRateTablesDefinition invoked");
		return rateTablesDefinitionService.update(rateTablesDefinition);
	}

	/*
	 * @DeleteMapping(value = "/{id}") public RateTable
	 * deleteRateTablesDefinition(@PathVariable String id) {
	 * 
	 * LOGGER.info("deleteRateTable invoked"); return
	 * rateTableService.delete(getRateTable(id)); }
	 */

}
