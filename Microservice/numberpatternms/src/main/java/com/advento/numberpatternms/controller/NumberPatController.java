package com.advento.numberpatternms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advento.numberpatternms.service.NumberPatService;



@RestController
public class NumberPatController {

	
	@Autowired
	@Qualifier(value = "numberpatternserviceimpl")
	private NumberPatService numPatternService;
	
	@GetMapping(value  = "/loopOne")
	public ResponseEntity<String> getLoopOne() {
		String loopObj = numPatternService.loopOne();
		ResponseEntity<String> response = new ResponseEntity<String>(loopObj,HttpStatus.OK);
		return response;
	}
	
	@GetMapping(value  = "/loopTwo")
	public ResponseEntity<String> getLoopTwo() {
		String loopObj2 = numPatternService.loopTwo();
		ResponseEntity<String> response = new ResponseEntity<String>(loopObj2,HttpStatus.OK);
		return response;
	}
	
	@GetMapping(value  = "/loopThree")
	public ResponseEntity<String> getLoopThree() {
		String loopObj3 = numPatternService.loopThree();
		ResponseEntity<String> response = new ResponseEntity<String>(loopObj3,HttpStatus.OK);
		return response;
	}
}
