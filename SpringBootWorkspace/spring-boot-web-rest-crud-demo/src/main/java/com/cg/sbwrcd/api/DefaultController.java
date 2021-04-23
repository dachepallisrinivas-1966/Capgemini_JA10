package com.cg.sbwrcd.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sbwrcd.exception.EmployeeException;

@RestController
@RequestMapping(path = "/")
public class DefaultController {
	
	@GetMapping
	public ResponseEntity<String> defaultAction() {
		return new ResponseEntity<>("Welcome to restful webservices", HttpStatus.OK);
	}

}
