package com.trax.ratemanager.amendment;

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

/**
 * Created by sudhakar.rao on 2/19/2019.
 */
@RestController
@RequestMapping("/amendments")
public class AmendmentController {

	@Autowired
	AmendmentService amendmentsSer;

	private static final Logger LOGGER = LoggerFactory.getLogger(AmendmentController.class);

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Amendment createAmandments(@RequestBody Amendment amendment) {

		LOGGER.info("addAmandments invoked");
		return amendmentsSer.create(amendment);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Amendment> getAmandments(@PathVariable String id) {
		LOGGER.info("getAmandments invoked");
		HttpStatus returnStatus = HttpStatus.OK;
		try {
			Amendment getAmendmentsDetail = amendmentsSer.getById(id);
			if (getAmendmentsDetail != null) {
				return new ResponseEntity<>(getAmendmentsDetail, returnStatus);
			} else {
				throw new ResourceNotFoundException("Amendment Id doesn't exist !");
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
	public Amendment updateAmandments(@RequestBody Amendment amendment) {

		LOGGER.info("updateAmandment invoked");
		return amendmentsSer.update(amendment);
	}

	@DeleteMapping(value = "/{id}")
	public Amendment deleteAmandments(@PathVariable String id) {

		LOGGER.info("deleteAmandment invoked");
		return null/* amendmentsSer.delete(id) */;
	}

}