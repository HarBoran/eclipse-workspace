package com.code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller	
public class DemoController {

	//home.jsp가 보여지도록 코딩하세요
	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}
	
	@GetMapping("/leaders")
	public String showLeaders() {
		
		return "leaders";
	}
	
	@GetMapping("/systems")
	public String showSystems() {
		
		return "systems";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDenied(){
		return "access-denied";
	}
}