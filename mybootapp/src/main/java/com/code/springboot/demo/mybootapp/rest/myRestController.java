package com.code.springboot.demo.mybootapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myRestController {

	@GetMapping("/")
	public String sayHello() {
		return "Hello Boot~!! Time on server is " + LocalDateTime.now();
	}

}
