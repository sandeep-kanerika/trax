package com.trax.ratemanager.rateset;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RateSetDownloadController
{

	@Autowired
	RateSetsService rateSetsSer;

	private static final Logger LOGGER = LoggerFactory.getLogger(RateSetDownloadController.class);

	@GetMapping("/downloads/rate-sets/{rateSetId}")
	public ResponseEntity<InputStreamResource> getRateSets(@PathVariable String rateSetId) throws IOException
	{
		log.info("getRateSets download invoked :::::-------------- " + rateSetId);
		ByteArrayInputStream in = rateSetsSer.getRateSetInExcelFormat(rateSetId);

		HttpHeaders headers = new HttpHeaders();
		String attachment = "attachment; filename=rateset_" + rateSetId + ".xlsx";
		headers.add("Content-Disposition", attachment);

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));

	}

	@GetMapping("/downloads/rate-sets/{rateSetId}/rate-tables/{tableId}")
	public ResponseEntity<RateSet> getRateSetsByTables(@PathVariable String rateSetId, @PathVariable String tableId)
	{
		LOGGER.info("getRateSets invoked :::::-------------- " + rateSetId);
		// get rateset and tables then convert into excel and return
		return null;
	}
}
