package com.trax.ratemanager.raterow.history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trax.ratemanager.exception.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RateRowHistoryController
{

	@Autowired
	RateRowHistoryService rateRowsHistoryService;

	@PostMapping(value = "/rate-rows/history", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> createRateRowsHistory(@RequestBody RateRowHistory rateRowsHistory)
	{

		log.info("***************Create Rate Rows History(PostRequest) ");
		log.info("***************Rate Rows History Object ::::" + rateRowsHistory);

		RateRowHistory createdRateRowHistory = null;
		try
		{
			createdRateRowHistory = rateRowsHistoryService.create(rateRowsHistory);
			log.info("***************Rate Rows History Object Created ::::" + createdRateRowHistory);
			return ResponseEntity.ok(createdRateRowHistory);
		}
		catch (Exception ex)
		{
			log.error("Error occured ::::" + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResourceNotFoundException("error", ex));
		}
	}

	@GetMapping("/rate-rows/history/latest")
	public ResponseEntity<RateRowHistory> getRateRowstHistoryLatest(@PathVariable String rootParentId)
	{
		log.info("***************Get Rate Rows History latest");
		return null;
	}

	@GetMapping("/rate-rows/{rootParentId}/history")
	public ResponseEntity<RateRowHistory> getRateRowsParentHistory(@PathVariable String rootParentId)
	{
		log.info("***************Get Rate Rows by Parent History");
		return null;
	}

	@GetMapping("/rate-rows/history")
	public ResponseEntity<List<RateRowHistory>> getCompleteRateRowHistory()
	{
		log.info("***************Get Rate Rows Parent History List");
		return null;
	}

	@GetMapping("/rate-rows/history/{id}")
	public ResponseEntity<RateRowHistory> getRateRowsHistory(@PathVariable String id)
	{
		log.info("***************Get Rate Rows History(GETREQUEST) ");
		HttpStatus returnStatus = HttpStatus.OK;
		try
		{
			RateRowHistory getRateRowHistoryDetail = rateRowsHistoryService.getById(id);
			log.info("***************Get Rate Row History Object ::::" + getRateRowHistoryDetail);
			if (getRateRowHistoryDetail != null)
			{
				return new ResponseEntity<>(getRateRowHistoryDetail, returnStatus);
			}
			else
			{
				throw new ResourceNotFoundException("Rate Rows History Id doesn't exist !");
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
}
