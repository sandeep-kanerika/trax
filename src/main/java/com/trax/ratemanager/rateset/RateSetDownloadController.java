package com.trax.ratemanager.rateset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/downloads/rate-sets")
public class RateSetDownloadController
{

	@Autowired
	RateSetsService rateSetsSer;

	private static final Logger LOGGER = LoggerFactory.getLogger(RateSetDownloadController.class);

	@GetMapping("/downloads/rate-sets/{rateSetId}")
	public ResponseEntity<RateSet> getRateSets(@PathVariable String rateSetId)
	{
		log.info("getRateSets invoked :::::-------------- " + rateSetId);
		// get rateset and tables then convert into excel and return
		return null;
	}

	@GetMapping("/downloads/rate-sets/{rateSetId}/rate-tables/{tableId}")
	public ResponseEntity<RateSet> getRateSetsByTables(@PathVariable String rateSetId, @PathVariable String tableId)
	{
		LOGGER.info("getRateSets invoked :::::-------------- " + rateSetId);
		// get rateset and tables then convert into excel and return
		return null;
	}
}
