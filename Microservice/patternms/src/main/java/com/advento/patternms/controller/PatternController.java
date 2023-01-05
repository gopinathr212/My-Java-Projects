package com.advento.patternms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advento.patternms.service.PatternService;
@RestController
public class PatternController {
 
	
	@Autowired
	@Qualifier(value = "patternserviceimpl")
	private PatternService patternService;
	
	@GetMapping(value  = "/rightAngleLoop")
	public ResponseEntity<String> getRightAngleLoop() {
		String loopObj = patternService.loopOne();
		ResponseEntity<String> response = new ResponseEntity<String>(loopObj,HttpStatus.OK);
		return response;
	}
	
	@GetMapping(value  = "/reverseRightloop")
	public ResponseEntity<String> getReverseRightAnLoop() {
		String loopObj1 = patternService.loopTwo();
		ResponseEntity<String> response = new ResponseEntity<String>(loopObj1,HttpStatus.OK);
		return response;
	}
	
	@GetMapping(value  = "/reverseEquviTriLoop")
	public ResponseEntity<String> getReverseEquviTriLoop() {
		String loopObj2 = patternService.loopThree();
		ResponseEntity<String> response = new ResponseEntity<String>(loopObj2,HttpStatus.OK);
		return response;
	}
	
	@GetMapping(value  = "/equviTriLoop")
	public ResponseEntity<String> getEquviTriLoop() {
		String loopObj3 = patternService.loopFour();
		ResponseEntity<String> response = new ResponseEntity<String>(loopObj3,HttpStatus.OK);
		return response;
	}
	
	@GetMapping(value  = "/diamondLoop")
	public ResponseEntity<String> getDiamondLoop() {
		String loopObj4 = patternService.loopFive();
		ResponseEntity<String> response = new ResponseEntity<String>(loopObj4,HttpStatus.OK);
		return response;
	}
	
	@GetMapping(value  = "/halfDiamnondloop")
	public ResponseEntity<String> getHalfDiamondLoop() {
		String loopObj5 = patternService.loopSix();
		ResponseEntity<String> response = new ResponseEntity<String>(loopObj5,HttpStatus.OK);
		return response;
	}
}
