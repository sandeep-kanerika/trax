package com.kanerika.product.ratemanager.column.definition;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kanerika.product.ratemanager.exception.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/column/definitions")
public class ColumnDefinitionsController {
	
	@Autowired
	ColumnDefinitionsService columnDefinitionSer;

	private static final Logger logger = LoggerFactory.getLogger(ColumnDefinitionsController.class);

	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ColumnDefinitions createColumnDefinitions(@RequestBody ColumnDefinitions columnDefinitions) {

		logger.info("addColumnDefinitions invoked");
		return columnDefinitionSer.create(columnDefinitions);
	}

	@GetMapping("/{id}")
	public ColumnDefinitions getColumnDefinitions(@PathVariable String id) {
		logger.info("getColumnDefinitions invoked");
		ColumnDefinitions getcolumnDefinitionDetail =  columnDefinitionSer.getById(id);
		if(getcolumnDefinitionDetail != null) {
			return getcolumnDefinitionDetail;
		}else {
			throw new ResourceNotFoundException("ColumnDefinition Id Doesn't Exists !");
		}
	}
	
//	@RequestMapping("/columndefinition")
//	public ColumnDefinition getColumnDefinitions() {
//		logger.info("getColumnDefinitions is invoked");
//		return columnDefinitionSer.getById();
//	}

	@RequestMapping(method = { RequestMethod.PUT , RequestMethod.PATCH })
	public ColumnDefinitions updateColumnDefinitions(@RequestBody ColumnDefinitions columnDefinitions) {

		logger.info("updateColumnDefinition invoked");
		return columnDefinitionSer.update(columnDefinitions);
	}

	@DeleteMapping(value = "/{id}")
	public ColumnDefinitions deleteColumnDefinitions(@PathVariable String id) {

		logger.info("deleteColumnDefinition invoked");
		return null/* columnDefinitionSer.delete(id) */;
	}
	
}
