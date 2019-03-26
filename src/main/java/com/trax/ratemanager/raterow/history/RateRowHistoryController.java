package com.trax.ratemanager.raterow.history;

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

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/rate-rows/history")
public class RateRowHistoryController {

	@Autowired
	RateRowHistoryService rateRowsHistorySer;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Object> createRateRowsHistory(@RequestBody RateRowHistory rateRowsHistory) {

		log.info("***************Create Rate Rows History(PostRequest) ");
		log.info("***************Rate Rows History Object ::::" + rateRowsHistory);
		
		RateRowHistory createdRateRowHistory = null;
		try {
			createdRateRowHistory = rateRowsHistorySer.create(rateRowsHistory);
			log.info("***************Rate Rows History Object Created ::::" + createdRateRowHistory);
			return ResponseEntity.ok(createdRateRowHistory);
		} catch (Exception ex) {
			log.error("Error occured ::::" + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResourceNotFoundException("error", ex));
		}
//		return rateRowsHistorySer.create(rateRowsHistory);
	}

	

	@GetMapping("/rate-rows/history/latest")
	public ResponseEntity<RateRowHistory> getRateRowstHistoryLatest(@PathVariable String rootParentId) {
		log.info("***************Get Rate Rows History");
		return null;
	}

	@GetMapping("/rate-rows/{rootParentId}/history")

	public ResponseEntity<RateRowHistory> getRateRowsParentHistory(@PathVariable String rootParentId) {
		log.info("***************Get Rate Rows Parent History");
		return null;
	}

	@GetMapping("/{id}")
	public ResponseEntity<RateRowHistory> getRateRowsHistory(@PathVariable String id) {
		log.info("***************Get Rate Rows History(GETREQUEST) ");
		HttpStatus returnStatus = HttpStatus.OK;
		try {
			RateRowHistory getRateRowHistoryDetail = rateRowsHistorySer.getById(id);
			log.info("***************Get Rate Row History Object ::::" + getRateRowHistoryDetail);
			if (getRateRowHistoryDetail != null) {
				return new ResponseEntity<>(getRateRowHistoryDetail, returnStatus);
			} else {
				throw new ResourceNotFoundException("Rate Rows History Id doesn't exist !");
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
	public RateRowHistory updateRateRowsHistory(@RequestBody RateRowHistory rateRowsHistory) {

		log.info("***************Update Rate Rows History");
		return rateRowsHistorySer.update(rateRowsHistory);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<RateRowHistory> deleteRateRowsHistory(@PathVariable String id) {

		log.info("***************Delete Rate Rows History(DELETEREQUEST) ");
		ResponseEntity<RateRowHistory> responseEntity = null;
		RateRowHistory rateRowHistory = rateRowsHistorySer.getById(id);
		log.info("**************found the Rate Rows History Id in DB ::::" + rateRowHistory);
		if (rateRowHistory != null) {
			try {
				rateRowsHistorySer.delete(rateRowHistory);
				log.info("Deleted the Rate Rows History Id from database ::::" + rateRowHistory.getId());
				return ResponseEntity.ok(rateRowHistory);
			} catch (Exception ex) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
