package com.trax.ratemanager.ratetable;

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

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/rate/tables")
public class RateTableController {

	@Autowired
	RateTableService rateTablesService;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public RateTable createRateTablesDefinition(@RequestBody RateTable rateTable) {

		log.info("***************Rate Tables Definition(PostRequest) ");
		log.info("***************Rate Tables Definition Object ::::" + rateTable);
		return rateTablesService.create(rateTable);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RateTable> getRateTablesDefinition(@PathVariable String id) {
		log.info("***************Get Rate Tables Definition ");
		HttpStatus returnStatus = HttpStatus.OK;
		try {
			RateTable getRateTableDetail = rateTablesService.getById(id);
			log.info("***************Get Rate Table Object ::::" + getRateTableDetail);
			if (getRateTableDetail != null) {
				return new ResponseEntity<>(getRateTableDetail, returnStatus);
			} else {
				throw new ResourceNotFoundException("Rate Table Definition Id doesn't exist !");
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

	@RequestMapping(method = { RequestMethod.PUT, RequestMethod.PATCH })
	public RateTable updateRateTablesDefinition(@RequestBody RateTable rateTablesDefinition) {

		log.info("***************Update Rate Tables Definition ");
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
