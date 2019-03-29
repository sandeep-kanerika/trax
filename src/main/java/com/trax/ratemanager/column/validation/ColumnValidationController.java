package com.trax.ratemanager.column.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/column-validations")
public class ColumnValidationController
{

	@Autowired
	ColumnValidationService columnValidationSer;

	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ColumnValidation createColumnValidations(@RequestBody ColumnValidation columnValidations)
	{

		log.info("***************Create Add Column Validations(PostRequest) ::::");
		log.info("***************Column Validations Object:::" + columnValidations);
		return columnValidationSer.create(columnValidations);
	}

	@RequestMapping("/{id}")
	public ResponseEntity<ColumnValidation> getColumnValidations(@PathVariable String id)
	{
		log.info("***************Get Column Validations(GETREQUEST) ");

		HttpStatus returnStatus = HttpStatus.OK;
		try
		{
			ColumnValidation columnValidationDetail = columnValidationSer.getById(id);
			log.info("***************Get Column Validations Object ::::" + columnValidationDetail);
			if (columnValidationDetail != null)
			{
				return new ResponseEntity<>(columnValidationDetail, returnStatus);
			}
			else
			{
				throw new ResourceNotFoundException("ColumnValidations Id doesn't exist !");
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

	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH})
	public ColumnValidation updateAmandments(@RequestBody ColumnValidation columnValidations)
	{

		log.info("***************Update Column Validations ::::" + columnValidations);
		return columnValidationSer.update(columnValidations);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ColumnValidation deleteColumnValidations(@PathVariable String id)
	{

		log.info("***************Delete Column Validations(DeleteRequest) ");
		return null/* ColumnValidationSer.delete(id) */;
	}

}
