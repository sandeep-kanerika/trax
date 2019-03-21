package com.trax.ratemanager.column.defination;

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

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "/column-definitions")
public class ColumnDefinitionsController {
	
	@Autowired
	ColumnDefinitionsService columnDefinitionSer;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Object> createColumnDefinitions(@RequestBody ColumnDefinitionVo columnDefinitionsVo) throws Exception {
		
		log.info("***************Create ColumnDefinitions(PostRequest) ");
		log.info("***************ColumnDefinitionsValue Object:::" + columnDefinitionsVo);

		RateColumnDefinition rateColumnDefinition = ColumnDefinitionConverter.convertToRateColumnDefinition(columnDefinitionsVo);
		log.info("***************ColumnDefinitions Object After VO--to-->BO:::" + rateColumnDefinition);
		RateColumnDefinition createdRateColumnDefinition = null;
		try {
			createdRateColumnDefinition = columnDefinitionSer.create(rateColumnDefinition);
			return ResponseEntity.ok(createdRateColumnDefinition);
		} catch (Exception ex) {
			log.error("Error occured:::" + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResourceNotFoundException("error", ex));
		}
	}

	@GetMapping("/filter/{id}")
	public RateColumnDefinition getFilteredColumnDefs
	(
			@PathVariable String id, 
			@PathVariable String concept,
			@PathVariable String name,
			@PathVariable String pageToken,
			@PathVariable Integer limit	
			)
	{
		System.out.println("ColumnDefinitionsController.getFilteredColumnDefs()....................");
		
	 return null;
	}
	@GetMapping("/{id}")
	public RateColumnDefinition getColumnDefinitions(@PathVariable String id) {
		log.info("getColumnDefinitions invoked");
		RateColumnDefinition getcolumnDefinitionDetail =  columnDefinitionSer.getById(id);
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
	public ResponseEntity<Object> updateColumnDefinitions(@RequestBody ColumnDefinitionVo columnDefinitionVo) throws Exception {

		log.info("updateColumnDefinition invoked");
		return createColumnDefinitions(columnDefinitionVo);
	}

	@DeleteMapping(value = "/{id}")
	public RateColumnDefinition deleteColumnDefinitions(@PathVariable String id) {

		log.info("deleteColumnDefinition invoked");
		return null/* columnDefinitionSer.delete(id) */;
	}
	
}