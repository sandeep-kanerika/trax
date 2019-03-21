package com.trax.ratemanager.column.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trax.ratemanager.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/column/validations")
public class ColumnValidationController {
	
	@Autowired
	ColumnValidationService columnValidationSer;

	private static final Logger LOGGER = LoggerFactory.getLogger(ColumnValidationController.class);

	@RequestMapping(/* value = "/ColumnValidation", */method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ColumnValidation createColumnValidations(@RequestBody ColumnValidation columnValidations) {

		LOGGER.info("addColumnValidations invoked");
		return columnValidationSer.create(columnValidations);
	}

	@RequestMapping("/{id}")
	public ResponseEntity<ColumnValidation> getColumnValidations(@PathVariable String id) {
		LOGGER.info("getColumnValidations invoked");
		HttpStatus returnStatus = HttpStatus.OK;
		try {
			ColumnValidation getAmendmentsDetail = columnValidationSer.getById(id);
			if (getAmendmentsDetail != null) {
				return new ResponseEntity<>(getAmendmentsDetail, returnStatus);
			} else {
				throw new ResourceNotFoundException("ColumnValidations Id doesn't exist !");
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
	public ColumnValidation updateAmandments(@RequestBody ColumnValidation columnValidations) {

		LOGGER.info("updateColumnValidations invoked");
		return columnValidationSer.update(columnValidations);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ColumnValidation deleteColumnValidations(@PathVariable String id) {

		LOGGER.info("deleteColumnValidations invoked");
		return null/* ColumnValidationSer.delete(id) */;
	}

}
