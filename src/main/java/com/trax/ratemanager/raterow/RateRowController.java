package com.trax.ratemanager.raterow;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trax.ratemanager.exception.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/rate-rows")
public class RateRowController {

	@Autowired
	RateRowService rateRowsService;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> createRateRows(@RequestBody RateRow rateRows) {

		log.info("***************Create Rate Rows(POSTREQUEST) ");
		log.info("***************Rate Rows Value Object ::::" + rateRows);
		RateRow createdRateRow = null;
		try {
			createdRateRow = rateRowsService.create(rateRows);
			log.info("***************Rate Rows Object Created ::::" + createdRateRow);
			return ResponseEntity.ok(createdRateRow);
		} catch (Exception ex) {
			log.error("Error occured ::::" + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResourceNotFoundException("error", ex));
		}
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> createRateRow(String ratesetId,String tableId, RateRowVo [] rateRowVo)
	{

		log.info("***************Add Rate Row(GETREQUEST) ");
		log.info("***************Rate Row Value Object ::::" + rateRowVo);
		RateRow createdRateRow = null;
		try {
			//createdRateRow = rateRowsService.create(rateRowVo);
			log.info("***************Rate Row Object Created ::::" + createdRateRow);
			return ResponseEntity.ok(createdRateRow);
		} catch (Exception ex) {
			log.error("Error occured ::::" + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResourceNotFoundException("error", ex));
		}
		//return rateRowsService.create(null);
	}

	@GetMapping("/rate-rows/distinct")
	public ResponseEntity<RateRow> getRateRowsDistinct(@RequestParam String filterOr, @RequestParam String rateSetId,
			@RequestParam String tableId,
			@RequestParam String search, @RequestParam String[] fields) {
		log.info("RateRowController.getRateRowsByFilter()............");
		return null;
	}

	
	@GetMapping("/rate-rows")
	public ResponseEntity<RateRow> getRateRowsByFilter(@RequestParam String filterOr, @RequestParam String rateSetId,
			@RequestParam String tableId, @RequestParam String sortBy, @RequestParam String sortOrder,
			@RequestParam String searchAfter, @RequestParam String[] fields, @RequestParam String pageToken,
			@RequestParam String limit) {
		log.info("RateRowController.getRateRowsByFilter()............");
		return null;
	}

	@PostMapping("/rate-rows/lookup")
	public ResponseEntity<RateRow> getRateRowsByFilter(@RequestBody Object object) {
          log.info("RateRowController.getRateRowsByFilter()");
		return null;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RateRow> getRateRows(@PathVariable String id) {
		log.info("***************Get Rate Rows(GETREQUEST) ");
		HttpStatus returnStatus = HttpStatus.OK;
		try {
			RateRow getRateRowDetail = rateRowsService.getById(id);
			log.info("***************Get Rate Rows Object ::::" + getRateRowDetail);
			if (getRateRowDetail != null) {
				return new ResponseEntity<>(getRateRowDetail, returnStatus);
			} else {
				throw new ResourceNotFoundException("RateRows Id doesn't exist !");
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

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public RateRow updateRateRows(@RequestBody RateRow rateRows) {

		log.info("***************Update Rate Rows ::::" + rateRows);
		return rateRowsService.update(rateRows);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteRateRows(@PathVariable String id) {

		log.info("***************Delete Rate Rows");
		rateRowsService.delete(id);
	}

}
