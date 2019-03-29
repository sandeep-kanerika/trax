package com.trax.ratemanager.ratetable.definition;

import java.util.List;

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
import com.trax.ratemanager.rateset.definition.RateSetDefinition;
import com.trax.ratemanager.rateset.definition.RateSetDefinitionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RateTableDefinitionController
{

	@Autowired
	private RateTableDefinitionService rateTablesDefinitionService;

	@Autowired
	private RateSetDefinitionService rateSetDefinitionService;

	@PostMapping(value = "/rate-tables-definition", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> createRateTablesDefinition(@RequestBody RateTableDefinitionVo rateTablesDefinitionVo) throws Exception
	{

		log.info("***************Create Rate Tables Definition(PostRequest) ");
		log.info("***************Rate Tables Definition Value Object ::::" + rateTablesDefinitionVo);
		RateTableDefinition rateTablesDefinition = RateTableDefinitionConverter.convertToRateTableDefinition(rateTablesDefinitionVo);
		RateSetDefinition existingDefinition = rateSetDefinitionService.getById(rateTablesDefinitionVo.getRateSetDefinitionId());
		log.info("***************Rate Tables Definition Object After VO--to-->BO ::::" + rateTablesDefinition);
		try
		{
			existingDefinition.getTables().add(rateTablesDefinition);
			rateSetDefinitionService.create(existingDefinition);
			return ResponseEntity.ok(existingDefinition);
		}
		catch (Exception ex)
		{
			log.error("Error occured:::" + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResourceNotFoundException("error", ex));
		}
	}

	@GetMapping("/rate-tables-definition")
	public ResponseEntity<List<RateTableDefinition>> getAllRateTableDefinitions()
	{
		log.info("***************Get all Rate Tables Definition");
		HttpStatus returnStatus = HttpStatus.OK;
		try
		{
			List<RateTableDefinition> getRateTableDefinitionDetail = rateTablesDefinitionService.findAll();
			log.info("***************Rate  All Table Definition Object ::::" + getRateTableDefinitionDetail);
			if (getRateTableDefinitionDetail != null)
			{
				return new ResponseEntity<>(getRateTableDefinitionDetail, returnStatus);
			}
			else
			{
				throw new ResourceNotFoundException("Rate Table Definition Id doesn't exist !");
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

	@GetMapping("/rate-tables-definition/{id}")
	public ResponseEntity<RateTableDefinition> getRateTablesDefinition(@PathVariable String id)
	{
		log.info("***************Get Rate Tables Definition");
		HttpStatus returnStatus = HttpStatus.OK;
		try
		{
			RateTableDefinition getRateTableDefinitionDetail = rateTablesDefinitionService.getById(id);
			log.info("***************Rate Table Definition Object ::::" + getRateTableDefinitionDetail);
			if (getRateTableDefinitionDetail != null)
			{
				return new ResponseEntity<>(getRateTableDefinitionDetail, returnStatus);
			}
			else
			{
				throw new ResourceNotFoundException("Rate Table Definition Id doesn't exist !");
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

	@PutMapping(value = "/rate-tables-definition", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> updateRateTablesDefinition(@RequestBody RateTableDefinitionVo rateTablesDefinitionVo) throws Exception
	{

		log.info("***************Update Rate Tables Definition ::::" + rateTablesDefinitionVo);
		return createRateTablesDefinition(rateTablesDefinitionVo);
	}

	@DeleteMapping(value = "/rate-tables-definition/{id}")
	public Boolean deleteRateTablesDefinition(@PathVariable String id)
	{
		log.info("deleteRateTableDefinition invoked");
		try
		{
			rateTablesDefinitionService.deleteById(id);
		}
		catch (Exception ex)
		{
			log.error("Failed to delete the rate table definition:" + id);
			return false;
		}
		return true;
	}

}
