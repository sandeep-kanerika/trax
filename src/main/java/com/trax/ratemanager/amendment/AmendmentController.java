package com.trax.ratemanager.amendment;

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
import org.springframework.web.bind.annotation.RestController;

import com.trax.ratemanager.exception.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by sandeep.sable on 3/20/2019.
 */
@RestController
@Slf4j
public class AmendmentController
{

	@Autowired
	AmendmentService amendmentService;

	@PostMapping(path = "/amendments", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> createAmandments(@RequestBody AmendmentVo amendmentVo) throws Exception
	{

		log.info("***************Create Amendments(PostRequest) ");
		log.info("***************AmendmentsValue Object ::::" + amendmentVo);

		Amendment amendment = AmendmentConverter.convertToAmendment(amendmentVo);
		log.info("***************Amendments Object After VO--to-->BO ::::" + amendment);
		Amendment createdAmendment = null;
		try
		{
			createdAmendment = amendmentService.create(amendment);
			log.info("***************Amendments Object Created ::::" + createdAmendment);
			return ResponseEntity.ok(createdAmendment);
		}
		catch (Exception ex)
		{
			log.error("Error occured ::::" + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResourceNotFoundException("error", ex));
		}
	}

	@GetMapping(path = "/amendments/{id}")
	public ResponseEntity<Amendment> getAmandments(@PathVariable String id)
	{
		log.info("***************Get Amandments(GETREQUEST) ");
		HttpStatus returnStatus = HttpStatus.OK;
		try
		{
			Amendment getAmendmentsDetail = amendmentService.getById(id);
			log.info("***************Get Amandments Object ::::" + getAmendmentsDetail);
			if (getAmendmentsDetail != null)
			{
				return new ResponseEntity<>(getAmendmentsDetail, returnStatus);
			}
			else
			{
				throw new ResourceNotFoundException("Amendment Id doesn't exist !");
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

	@PutMapping(path = "/amendments")
	public ResponseEntity<Object> updateAmandments(@RequestBody AmendmentVo amendmentVo) throws Exception
	{

		log.info("***************Update Amandment ::::" + amendmentVo);
		return createAmandments(amendmentVo);
	}

	@DeleteMapping(path = "/amendments/{id}")
	public ResponseEntity deleteAmandments(@PathVariable String id)
	{

		ResponseEntity responseEntity = null;
		log.info("**************deleteAmendment invoked with id:::" + id);
		Boolean flag = amendmentService.delete(id);
		log.info("**************delete the amendment result:::" + flag);
		if (flag)
		{
			responseEntity = ResponseEntity.status(HttpStatus.OK).build();
		}
		else
		{
			responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return responseEntity;
	}

	@PostMapping(value = "/amendments/save-as-draft", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Amendment> saveAmendmentAsDraft(@RequestBody AmendmentWithRateRows amendmentWithRateRows)
	{
		log.info("**************Save Draft Amendment(PostRequest) ::::");
		log.info("***************AmendmentsValue Object ::::" + amendmentWithRateRows);
		return null;
		// some response , need to be implemented.
	}

	@PostMapping(value = "/amendments/submit-for-approval", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Amendment> submitAmendmentForApproval(@RequestBody AmendmentWithMeta amendmentWithMeta)
	{
		log.info("**************submitForApproval invoked ::::");
		log.info("***************AmendmentsValue Object ::::" + amendmentWithMeta);
		return null;
		// some response , need to be implemented.

	}

	@PostMapping(value = "/amendments/approve-rates", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Amendment> approveAnAmendment(@RequestBody AmendmentWithRateRows amendmentWithMeta)
	{
		log.info("**************Approve Rates invoked(PostRequest) ::::");
		log.info("***************AmendmentsValue Object ::::" + amendmentWithMeta);
		return null;
		// some response , need to be implemented.

	}
}
