package com.matchmaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.matchmaker.pojo.ComplexPojo;
import com.matchmaker.services.DemoService;

@RestController
public class DemoController {
	
	@Autowired
	DemoService ds;

	@PostMapping("/demo")
	public ResponseEntity<ComplexPojo> demo(@RequestBody ComplexPojo cp ){
		System.out.println(cp.toString());
		ds.saveIntoDb(cp);
		return new ResponseEntity<ComplexPojo> (cp , HttpStatus.OK);
	}
	
	
	
}
