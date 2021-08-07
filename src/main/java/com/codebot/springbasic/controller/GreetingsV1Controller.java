package com.codebot.springbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codebot.springbasic.model.Greetings;
import com.codebot.springbasic.service.GreetingsV1Service;

@RestController
@RequestMapping(value = { "/api/v1/greetings" })
public class GreetingsV1Controller {

	@Autowired
	private GreetingsV1Service greetingsV1Service;

	@GetMapping
	public ResponseEntity<Greetings> greet() {
		return new ResponseEntity<>(greetingsV1Service.greet(), HttpStatus.OK);
	}

}
