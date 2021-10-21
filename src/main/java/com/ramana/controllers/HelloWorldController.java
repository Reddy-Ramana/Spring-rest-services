package com.ramana.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {

	@RequestMapping(method=RequestMethod.GET,path="/Hello-World")
	public String hellowWorld() {

		return "Hello World !!!";
	}

}
