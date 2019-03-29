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

@RestController
@Slf4j
public class RateColumnController
{

	@Autowired
	RateColumnService rateColumnService;

	@PostMapping(value = "/rate-column", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> createRateColumn(@RequestBody RateColumnVo rateColumnVo) throws Exception
	{
		log.info("***************Create Rate Column(PostRequest) ");
		log.info("***************Rate Column Value Object ::::" + rateColumnVo);
		RateColumn rateColumn = RateColumnConverter.convertToRateColumn(rateColumnVo);
		log.info("***************Rate Column Object After VO--to-->BO ::::" + rateColumn);
		RateColumn createdRateColumn = null;
		try
		{
			createdRateColumn = rateColumnService.create(rateColumn);
			return ResponseEntity.ok(createdRateColumn);
		}
		catch (Exception ex)
		{
			log.error("Error occured ::::" + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResourceNotFoundException("error", ex));
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<RateColumn> getRateColumn(@PathVariable String id)
	{
		log.info("***************Get Rate Column(GETREQUEST) ");
		HttpStatus returnStatus = HttpStatus.OK;
		try
		{
			RateColumn getRateColumnDetail = rateColumnService.getById(id);
			log.info("***************Get Rate Column Object ::::" + getRateColumnDetail);
			if (getRateColumnDetail != null)
			{
				return new ResponseEntity<>(getRateColumnDetail, returnStatus);
			}
			else
			{
				throw new ResourceNotFoundException("RateColumn Id doesn't exist !");
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

	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<RateColumn> updateRateColumn(@RequestBody RateColumnVo rateColumnVo) throws Exception
	{
		RateColumn rateColumn = RateColumnConverter.convertToRateColumn(rateColumnVo);
		log.info("update rate column invoked" + rateColumn);
		return new ResponseEntity<RateColumn>(rateColumnService.update(rateColumn), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<RateColumn> deleteColumnValidations(@PathVariable String id)
	{

		log.info("delete rate column invoked");
		rateColumnService.getRepository().deleteById(id);
		return new ResponseEntity<RateColumn>(HttpStatus.OK);
	}

}
