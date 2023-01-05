package com.advento.printms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.advento.printms.service.PrintService;

@RestController
public class PrintController {

	@Autowired
	@Qualifier(value = "printserviceimpl")
	private PrintService printService;
	
	@GetMapping(value  = "/div")
	public ResponseEntity<String> getDiv(@RequestParam(value = "length") int length) {
		String loopObj = printService.div(length);
		ResponseEntity<String> response = new ResponseEntity<String>(loopObj,HttpStatus.OK);
		return response;
	}
	
	@GetMapping(value  = "/even")
	public ResponseEntity<String> getEven(@RequestParam(value = "length") int length) {
		String loopObj1 = printService.even(length);
		ResponseEntity<String> response = new ResponseEntity<String>(loopObj1,HttpStatus.OK);
		return response;
	}
	
	@GetMapping(value  = "/odd")
	public ResponseEntity<String> getOdd(@RequestParam(value = "length") int length) {
		String loopObj2 = printService.odd(length);
		ResponseEntity<String> response = new ResponseEntity<String>(loopObj2,HttpStatus.OK);
		return response;
	}
}
