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

@RestController
@RequestMapping("/ratetable")
public class RateTableController {

	@Autowired
	RateTableService rateTableService;

	private static final Logger LOGGER = LoggerFactory.getLogger(RateTableController.class);

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public RateTable createRateTables(@RequestBody RateTable rateTable) {

		LOGGER.info("post rate table  invoked");
		return rateTableService.create(rateTable);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RateTable> getRateTable(@PathVariable Long id) {
		LOGGER.info("geRateTable invoked");
		HttpStatus returnStatus = HttpStatus.OK;
		try {
			RateTable getAmendmentsDetail = rateTableService.getById(id);

			if (getAmendmentsDetail != null) {
				return new ResponseEntity<>(getAmendmentsDetail, returnStatus);
			} else {
				throw new ResourceNotFoundException("RateTable Id doesn't exist !");
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
	public RateTable updateRateTable(@RequestBody RateTable rateRows) {

		LOGGER.info("update rate table invoked");
		return rateTableService.update(rateRows);
	}

	@DeleteMapping(value = "/{id}")
	public RateTable deleteRateTable(@PathVariable Long id) {

		LOGGER.info("deleteRateTable invoked");
		return rateTableService.delete(rateTableService.getById(id));
		
	}

}
