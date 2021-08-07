package com.codebot.springbasic.service;

import org.springframework.stereotype.Service;

import com.codebot.springbasic.model.Greetings;

@Service
public class GreetingsV1ServiceImpl implements GreetingsV1Service {

	@Override
	public Greetings greet() {
		return new Greetings("Howdy User!!! Hello from API");
	}

}
