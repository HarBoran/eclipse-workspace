package com.code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showMyLogin() {
		
//		return "plain-login";
		return "fancy-login";
	}
	
	@GetMapping("/test")
	public String test() {		
		return "test";
	}
	

}
