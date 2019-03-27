package com.trax.ratemanager.column.defination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trax.ratemanager.exception.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ColumnDefinitionController {

	@Autowired
	ColumnDefinitionService columnDefinitionSer;

	@GetMapping("/column-definitions")
	public ColumnDefinition getColumnDefinitions(@PathVariable String id) {
		log.info("getColumnDefinitions invoked");
		ColumnDefinition getcolumnDefinitionDetail = columnDefinitionSer.getById(id);
		if (getcolumnDefinitionDetail != null) {
			return getcolumnDefinitionDetail;
		} else {
			throw new ResourceNotFoundException("ColumnDefinition Id Doesn't Exists !");
		}
	}

	@PostMapping(value = "/column-definitions", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> createColumnDefinitions(@RequestBody ColumnDefinitionVo columnDefinitionsVo)
			throws Exception {

		log.info("***************Create ColumnDefinitions(PostRequest) ");
		log.info("***************ColumnDefinitionsValue Object:::" + columnDefinitionsVo);

		ColumnDefinition colDefinition = ColumnDefinitionConverter.convertToRateColumnDefinition(columnDefinitionsVo);
		log.info("***************ColumnDefinitions Object After VO--to-->BO:::" + colDefinition);
		ColumnDefinition createdRateColumnDefinition = null;
		try {
			createdRateColumnDefinition = columnDefinitionSer.create(colDefinition);
			return ResponseEntity.ok(createdRateColumnDefinition);
		} catch (Exception ex) {
			log.error("Error occured:::" + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResourceNotFoundException("error", ex));
		}
	}

}
