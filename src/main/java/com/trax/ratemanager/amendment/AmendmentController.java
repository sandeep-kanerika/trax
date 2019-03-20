package com.trax.ratemanager.amendment;

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
import com.trax.ratemanager.rateset.RateSet;
import com.trax.ratemanager.rateset.RateSetController;
import com.trax.ratemanager.rateset.RateSetConverter;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by sudhakar.rao on 2/19/2019.
 */
@RestController
@Slf4j
@RequestMapping("/amendments")
public class AmendmentController {

	@Autowired
	AmendmentService amendmentsSer;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Object> createAmandments(@RequestBody AmendmentVo amendmentVo) throws Exception {
		
//		LOGGER.info("addAmandments invoked");
//		return amendmentsSer.create(amendment);
		log.info("***************Create RateSet(PostRequest) ");
		log.info("***************RateSetValue Object:::" + amendmentVo);
		Amendment amendment = AmendmentConverter.convertToAmendment(amendmentVo);
		log.info("***************RateSet Object After VO--to-->BO:::" + amendment);
		Amendment createdAmendment = null;
		try 
		{
			createdAmendment = amendmentsSer.create(amendment);
			return ResponseEntity.ok(createdAmendment);
		} catch (Exception ex) 
		{
			log.error("Error occured:::" + ex.getMessage());
		     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResourceNotFoundException("error",ex));
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Amendment> getAmandments(@PathVariable String id) {
		log.info("getAmandments invoked");
		HttpStatus returnStatus = HttpStatus.OK;
		try {
			Amendment getAmendmentsDetail = amendmentsSer.getById(id);
			if (getAmendmentsDetail != null) {
				return new ResponseEntity<>(getAmendmentsDetail, returnStatus);
			} else {
				throw new ResourceNotFoundException("Amendment Id doesn't exist !");
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
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<Object> updateAmandments(@RequestBody AmendmentVo amendmentVo) throws Exception {

		log.info("updateAmandment invoked");
		return createAmandments(amendmentVo);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Amendment> deleteAmandments(@PathVariable String id) {

		ResponseEntity<Amendment> responseEntity = null;
		log.info("**************deleteAmendment invoked with id:::" + id);
		Amendment amendment = amendmentsSer.getById(id);
		log.info("**************found the amendment id in DB:::" + amendment);
		if (amendment != null) 
		{
			try 
			{
				amendmentsSer.delete(amendment);
				log.info("deleted the amendmentId from database..." + amendment.getId());
				return ResponseEntity.ok(amendment);
			} catch (Exception ex) 
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
		} else 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
