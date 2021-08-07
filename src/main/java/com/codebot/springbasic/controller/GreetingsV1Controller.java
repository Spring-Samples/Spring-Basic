package com.codebot.springbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codebot.springbasic.model.Greetings;
import com.codebot.springbasic.service.GreetingsV1Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = { "/api/v1/greetings" })
@Api(value = "Greetings API V1", tags = { "Greetings API V1" })
@ApiResponses(
		value = {
				@ApiResponse(code = 200, message = "Success", response = Object.class),
				@ApiResponse(code = 400, message = "Bad Request"),
				@ApiResponse(code = 401, message = "Unauthorized"),
				@ApiResponse(code = 403, message = "Forbidden"),
				@ApiResponse(code = 404, message = "Not Found"),
				@ApiResponse(code = 500, message = "Internal Server Error")
		}
)
public class GreetingsV1Controller {

	@Autowired
	private GreetingsV1Service greetingsV1Service;

	@GetMapping
	@ApiOperation(value = "Greet Users")
	public ResponseEntity<Greetings> greet() {
		return new ResponseEntity<>(greetingsV1Service.greet(), HttpStatus.OK);
	}

}
