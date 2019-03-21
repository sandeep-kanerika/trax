package com.trax.ratemanager.ratetable.definition;

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
@RequestMapping("/rate/tables/definition")
public class RateTableDefinitionController {

	@Autowired
	RateTableDefinitionService rateTablesDefinitionService;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<Object> createRateTablesDefinition(@RequestBody RateTableDefinitionVo rateTablesDefinitionVo) throws Exception {

		log.info("***************Create rateTablesDefinition(PostRequest) ");
		log.info("***************rateTablesDefinitionValue Object:::" + rateTablesDefinitionVo);
		RateTableDefinition rateTablesDefinition = RateTableDefinitionConverter.convertToRateTable(rateTablesDefinitionVo);
		log.info("***************rateTablesDefinition Object After VO--to-->BO:::" + rateTablesDefinition);
		RateTableDefinition createdRateTablesDefinition = null;
		try 
		{
			createdRateTablesDefinition = rateTablesDefinitionService.create(rateTablesDefinition);
			return ResponseEntity.ok(createdRateTablesDefinition);
		} catch (Exception ex) 
		{
			log.error("Error occured:::" + ex.getMessage());
		     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResourceNotFoundException("error",ex));
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<RateTableDefinition> getRateTablesDefinition(@PathVariable String id) {
		log.info("getRateTablesDefinition invoked");
		HttpStatus returnStatus = HttpStatus.OK;
		try {
			RateTableDefinition getAmendmentsDetail = rateTablesDefinitionService.getById(id);

			if (getAmendmentsDetail != null) {
				return new ResponseEntity<>(getAmendmentsDetail, returnStatus);
			} else {
				throw new ResourceNotFoundException("RateTableDefinition Id doesn't exist !");
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
	public ResponseEntity<Object> updateRateTablesDefinition(@RequestBody RateTableDefinitionVo rateTablesDefinitionVo) throws Exception {

		log.info("updateRateTablesDefinition invoked");
		return createRateTablesDefinition(rateTablesDefinitionVo);
	}

	/*
	 * @DeleteMapping(value = "/{id}") public RateTable
	 * deleteRateTablesDefinition(@PathVariable String id) {
	 * 
	 * log.info("deleteRateTable invoked"); return
	 * rateTableService.delete(getRateTable(id)); }
	 */

}
