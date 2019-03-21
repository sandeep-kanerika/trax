package com.trax.ratemanager.amendment.history;

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

import com.trax.ratemanager.amendment.Amendment;
import com.trax.ratemanager.amendment.AmendmentConverter;
import com.trax.ratemanager.amendment.AmendmentVo;
import com.trax.ratemanager.exception.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by sudhakar.rao on 2/19/2019.
 */
@RestController
@Slf4j
@RequestMapping("/amendments/history")
public class AmendmentHistoryController {

	@Autowired
	AmendmentHistoryService amendmentsHistorySer;

	private static final Logger LOGGER = LoggerFactory.getLogger(AmendmentHistoryController.class);

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<Object> createAmendmentsHistory(@RequestBody AmendmentHistoryVo amendmentsHistoryVo)
			throws Exception {

		log.info("***************Create AmendmentsHistory(PostRequest) ");
		log.info("***************AmendmentsHistoryValue Object:::" + amendmentsHistoryVo);
		AmendmentHistory amendmentsHistory = AmendmentHistoryConverter.convertToAmendmentHistory(amendmentsHistoryVo);
		log.info("***************AmendmentsHistory Object After VO--to-->BO:::" + amendmentsHistory);
		AmendmentHistory createdAmendmentHistory = null;
		try {
			createdAmendmentHistory = amendmentsHistorySer.create(amendmentsHistory);
			return ResponseEntity.ok(createdAmendmentHistory);
		} catch (Exception ex) {
			log.error("Error occured:::" + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResourceNotFoundException("error", ex));
		}
	}

	@RequestMapping(method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<Object> updateAmendmentsHistory(@RequestBody AmendmentHistoryVo amendmentsHistoryVo)
			throws Exception {
		log.info("updateAmandmentHistory invoked");
		return createAmendmentsHistory(amendmentsHistoryVo);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<AmendmentHistory> deleteAmendmentsHistory(@PathVariable String id) {

		ResponseEntity<AmendmentHistory> responseEntity = null;
		log.info("**************deleteAmendmentHistory invoked with id:::" + id);
		AmendmentHistory amendmentHistory = amendmentsHistorySer.getById(id);
		log.info("**************found the amendmentHistory id in DB:::" + amendmentHistory);
		if (amendmentHistory != null) {
			try {
				amendmentsHistorySer.delete(amendmentHistory);
				log.info("deleted the amendmentHistoryId from database..." + amendmentHistory.getId());
				return ResponseEntity.ok(amendmentHistory);
			} catch (Exception ex) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<AmendmentHistory> getAmendmentsHistoryByTheId(@PathVariable String id) {
		LOGGER.info("getAmandmentsHistory invoked");
		HttpStatus returnStatus = HttpStatus.OK;

		try {
			AmendmentHistory getAmendmentHistoryDetail = amendmentsHistorySer.getById(id);
			if (getAmendmentHistoryDetail != null) {
				return new ResponseEntity<>(getAmendmentHistoryDetail, returnStatus);
			} else {
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

	@GetMapping("/history")
	public ResponseEntity<Amendment> getAmandmentHistory(@RequestBody AmendmentVo amendmentVo) {
		System.out.println("---getAmandmentHistory---amendmentVo---->" + amendmentVo);

		return null; // some response , need to be implemented.

	}

	@GetMapping("/summary/submission-to-review")
	public ResponseEntity<Amendment> getAmandmentSubmissionToReview(@PathVariable String id) {
		System.out.println("---getAmandmentSubmissionToReview---ID---->" + id);
		return null;
	}

}
