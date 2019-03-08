package com.kanerika.product.ratemanager.raterow.history;

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

@RestController
@RequestMapping("/rate/rows/history")
public class RateRowsHistoryController {
	
	@Autowired
	RateRowsHistoryService rateRowsHistorySer;

	private static final Logger LOGGER = LoggerFactory.getLogger(RateRowsHistoryController.class);

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public RateRowsHistory createRateRowsHistory(@RequestBody RateRowsHistory rateRowsHistory) {

		LOGGER.info("addRateRowsHistory invoked");
		return rateRowsHistorySer.create(rateRowsHistory);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RateRowsHistory> getRateRowsHistory(@PathVariable String id) {
		LOGGER.info("getRateRowsHistory invoked");
		HttpStatus returnStatus = HttpStatus.OK;
		try {
			RateRowsHistory getAmendmentsDetail = rateRowsHistorySer.getById(id);
			if (getAmendmentsDetail != null) {
				return new ResponseEntity<>(getAmendmentsDetail, returnStatus);
			} else {
				throw new ResourceNotFoundException("RateRowsHistory Id doesn't exist !");
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
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH})
	public RateRowsHistory updateRateRowsHistory(@RequestBody RateRowsHistory rateRowsHistory) {

		LOGGER.info("updateRateRowsHistory invoked");
		return rateRowsHistorySer.update(rateRowsHistory);
	}

	@DeleteMapping(value = "/{id}")
	public RateRowsHistory deleteRateRowsHistory(@PathVariable String id) {

		LOGGER.info("deleteRateRowsHistory invoked");
		return null/* rateRowsHistorySer.delete(id) */;
	}
}
