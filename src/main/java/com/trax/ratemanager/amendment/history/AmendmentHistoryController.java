package com.trax.ratemanager.amendment.history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trax.ratemanager.amendment.Amendment;
import com.trax.ratemanager.amendment.AmendmentVo;
import com.trax.ratemanager.exception.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by sudhakar.rao on 2/19/2019.
 */
@RestController
@Slf4j

public class AmendmentHistoryController
{

	@Autowired
	AmendmentHistoryService amendmenHistService;

	@PostMapping(value = "/amendments/history", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})

	public ResponseEntity<Object> createAmendmentsHistory(@RequestBody AmendmentHistoryVo amendmentsHistoryVo) throws Exception
	{

		log.info("***************Create AmendmentsHistory(PostRequest) ");
		log.info("***************Amendments History Value Object :::" + amendmentsHistoryVo);
		AmendmentHistory amendmentsHistory = AmendmentHistoryConverter.convertToAmendmentHistory(amendmentsHistoryVo);
		log.info("***************Amendments History Object After VO--to-->BO :::" + amendmentsHistory);
		AmendmentHistory createdAmendmentHistory = null;
		try
		{
			createdAmendmentHistory = amendmenHistService.create(amendmentsHistory);
			return ResponseEntity.ok(createdAmendmentHistory);
		}
		catch (Exception ex)
		{
			log.error("Error occured:::" + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResourceNotFoundException("error", ex));
		}
	}

	@GetMapping("/amendments/history/{id}")
	public ResponseEntity<AmendmentHistory> findAmendmentHistoryById(@PathVariable String id)
	{
		log.info("**************get Amandments History(GET REQUEST)");
		HttpStatus returnStatus = HttpStatus.OK;

		try
		{
			AmendmentHistory getAmendmentHistoryDetail = amendmenHistService.getById(id);
			log.info("***************Get Amandments History Object ::::" + getAmendmentHistoryDetail);
			if (getAmendmentHistoryDetail != null)
			{
				return new ResponseEntity<>(getAmendmentHistoryDetail, returnStatus);
			}
			else
			{
				throw new ResourceNotFoundException("Amendments History Id Doesn't Exists !");
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

	@GetMapping("/amendments/history")
	public ResponseEntity<List<AmendmentHistory>> getAmandmentHistory(@RequestBody AmendmentVo amendmentVo)
	{
		log.info("***************Get Amandment History ::::" + amendmentVo);
		return null;
		// some response , need to be implemented.

	}

	@GetMapping("/amendments/history/summary/submission-to-review")
	public ResponseEntity<Amendment> getAmandmentHistorySubmissionToReview(@PathVariable String id)
	{
		log.info("***************Get Amandment History Submission Review ID ::::" + id);
		return null;
	}

}
