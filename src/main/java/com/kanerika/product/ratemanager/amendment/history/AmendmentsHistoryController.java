package com.kanerika.product.ratemanager.amendment.history;

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

/**
 * Created by sudhakar.rao on 2/19/2019.
 */
@RestController
@RequestMapping("/amendments/history")
public class AmendmentsHistoryController {
	
	@Autowired
	AmendmentsHistoryService amendmentsHistorySer;


	private static final Logger LOGGER = LoggerFactory.getLogger(AmendmentsHistoryController.class);
	
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public AmendmentsHistory createAmendmentsHistory(@RequestBody AmendmentsHistory amendmentsHistory) {

		LOGGER.info("addAmendmentsHistory invoked");
		return amendmentsHistorySer.create(amendmentsHistory);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AmendmentsHistory> getAmendmentsHistory(@PathVariable Long id) {
		LOGGER.info("getAmandmentsHistory invoked");
		HttpStatus returnStatus = HttpStatus.OK;
		
		try {
			AmendmentsHistory getAmendmentHistoryDetail =  amendmentsHistorySer.getById(id);
			if(getAmendmentHistoryDetail != null ) {
				return new ResponseEntity<>(getAmendmentHistoryDetail, returnStatus);
			}else {
				throw new ResourceNotFoundException("AmendmentsHistory Id Doesn't Exists !");
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
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH })
	public AmendmentsHistory updateAmendmentsHistory(@RequestBody AmendmentsHistory amendmentsHistory) {

		LOGGER.info("updateAmandmentsHistory invoked");
		return amendmentsHistorySer.update(amendmentsHistory);
	}

	@DeleteMapping(value = "/{id}")
	public AmendmentsHistory deleteAmendmentsHistory(@PathVariable Long id) {

		LOGGER.info("deleteAmendmentsHistory invoked");
		return null/* amendmentsHistorySer.delete(id) */;
	}
	
}
