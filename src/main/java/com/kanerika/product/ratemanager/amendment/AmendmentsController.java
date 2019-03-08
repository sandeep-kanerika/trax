package com.kanerika.product.ratemanager.amendment;

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
@RequestMapping("/amendments")
public class AmendmentsController {

	@Autowired
	AmendmentsService amendmentsSer;

	private static final Logger LOGGER = LoggerFactory.getLogger(AmendmentsController.class);

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Amendments createAmandments(@RequestBody Amendments amendment) {

		LOGGER.info("addAmandments invoked");
		return amendmentsSer.create(amendment);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Amendments> getAmandments(@PathVariable String id) {
		LOGGER.info("getAmandments invoked");
		HttpStatus returnStatus = HttpStatus.OK;
		try {
			Amendments getAmendmentsDetail = amendmentsSer.getById(id);
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
	public Amendments updateAmandments(@RequestBody Amendments amendment) {

		LOGGER.info("updateAmandment invoked");
		return amendmentsSer.update(amendment);
	}

	@DeleteMapping(value = "/{id}")
	public Amendments deleteAmandments(@PathVariable String id) {

		LOGGER.info("deleteAmandment invoked");
		return null/* amendmentsSer.delete(id) */;
	}

}
