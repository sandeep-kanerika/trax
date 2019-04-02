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
import org.springframework.web.bind.annotation.RestController;

import com.trax.ratemanager.exception.ResourceNotFoundException;
import com.trax.ratemanager.rateset.RateSet;
import com.trax.ratemanager.rateset.RateSetsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/rate/tables")
public class RateTableController
{

	@Autowired
	RateTableService rateTablesService;
	
	@Autowired
	private RateSetsService rateSetsService;


	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> createRateTables(@RequestBody RateTableVo rateTableVo) throws Exception
	{

		log.info("***************Rate Tables (PostRequest) ");
		log.info("***************Rate Tables  Object ::::" + rateTableVo);
		RateTable rateTable = RateTableConverter.convertToRateTable(rateTableVo);
		RateSet existingRateSet = rateSetsService.getById(rateTableVo.getRateSetId());
		log.info("***************Rate Tables Object After VO--to-->BO ::::" + rateTable);
		
		try
		{
			existingRateSet.getTables().add(rateTable);
			rateSetsService.create(existingRateSet);
			return ResponseEntity.ok(existingRateSet);
		}
		catch (Exception ex)
		{
			log.error("Error occured:::" + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResourceNotFoundException("error", ex));
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<RateTable> getRateTables(@PathVariable String id)
	{
		log.info("***************Get Rate Tables  ");
		HttpStatus returnStatus = HttpStatus.OK;
		try
		{
			RateTable getRateTableDetail = rateTablesService.getById(id);
			log.info("***************Get Rate Table Object ::::" + getRateTableDetail);
			if (getRateTableDetail != null)
			{
				return new ResponseEntity<>(getRateTableDetail, returnStatus);
			}
			else
			{
				throw new ResourceNotFoundException("Rate Table  Id doesn't exist !");
			}
		}
		catch (ResourceNotFoundException e)
		{
			log.error(e.getMessage());
			returnStatus = HttpStatus.NOT_FOUND;
		}
		catch (Exception e)
		{
			returnStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			log.error(e.getMessage());
		}
		return new ResponseEntity<>(returnStatus);
	}

	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH})
	public RateTable updateRateTables(@RequestBody RateTable rateTables)
	{

		log.info("***************Update Rate Tables  ");
		return rateTablesService.update(rateTables);
	}

	/*
	 * @DeleteMapping(value = "/{id}") public RateTable
	 * deleteRateTables(@PathVariable String id) {
	 * 
	 * LOGGER.info("deleteRateTable invoked"); return
	 * rateTableService.delete(getRateTable(id)); }
	 */

}
