package com.kanerika.product.ratemanager.ratetable;

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

import com.kanerika.product.ratemanager.exception.ResourceNotFoundException;

import jdk.nashorn.internal.runtime.FindProperty;

@RestController
@RequestMapping("/rate/tables")
public class RateTablesDefinitionController {

	@Autowired
	RateTablesDefinitionService rateTablesDefinitionService;

	private static final Logger LOGGER = LoggerFactory.getLogger(RateTablesDefinitionController.class);

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public RateTablesDefinition createRateTablesDefinition(@RequestBody RateTablesDefinition rateTablesDefinition) {

		LOGGER.info("rateTablesDefinition invoked");
		return rateTablesDefinitionService.create(rateTablesDefinition);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RateTablesDefinition> getRateTablesDefinition(@PathVariable Long id) {
		LOGGER.info("getRateTablesDefinition invoked");
		HttpStatus returnStatus = HttpStatus.OK;
		try {
			RateTablesDefinition getAmendmentsDetail = rateTablesDefinitionService.getById(id);

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
	public RateTablesDefinition updateRateTablesDefinition(@RequestBody RateTablesDefinition rateTablesDefinition) {

		LOGGER.info("updateRateTablesDefinition invoked");
		return rateTablesDefinitionService.update(rateTablesDefinition);
	}

	/*
	 * @DeleteMapping(value = "/{id}") public RateTable
	 * deleteRateTablesDefinition(@PathVariable Long id) {
	 * 
	 * LOGGER.info("deleteRateTable invoked"); return
	 * rateTableService.delete(getRateTable(id)); }
	 */

}
