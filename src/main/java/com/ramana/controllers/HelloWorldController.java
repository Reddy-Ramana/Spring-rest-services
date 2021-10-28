package com.ramana.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ramana.pojo.HelloWorld;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(method = RequestMethod.GET, path = "/Hello-World")
	public String hellowWorld() {

		return messageSource.getMessage("Hello.World.Code", null, "Hello world default",
				LocaleContextHolder.getLocale());
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorld helloWorldBean() {

		return new HelloWorld("Hello World From Bean!!!!!!");
	}

	@GetMapping(path = "/hello-world-bean/path-variable/{name}")
	public HelloWorld helloWorldBeanWithPathVariable(@PathVariable String name) {

		return new HelloWorld(String.format("Hello World From Bean with path variable %S", name));
	}

}
