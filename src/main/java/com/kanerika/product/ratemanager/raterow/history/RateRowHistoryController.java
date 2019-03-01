package com.kanerika.product.ratemanager.raterow.history;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/raterowhistory")
public class RateRowHistoryController {
	
//	@Autowired
//	private RateRowHistoryController RateRowHistoryRepo;
//	
//	@RequestMapping( value = "/value" , method = RequestMethod.GET) 
//	public ResponseEntity<Collection<RateRowHistory>> getAmendment() {
//		
//		System.out.println(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())); 
//		return new ResponseEntity<>(RateRowHistoryRepo.findAll(), HttpStatus.OK); 
//		  
//	}
	
	@GetMapping("/hello")
	public String getMsg() {
		return "Hello RateRowHistoryController";
	}

}
