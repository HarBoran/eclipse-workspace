package com.code.springdemo.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.code.springdemo.dao.CustomerDAO;
import com.code.springdemo.entity.Customer;

@Controller //MVC의 컨트롤러라는 것을 알려줌
@RequestMapping("/customer") //URL 주소 매핑
public class CustomerController {	
		
	//customerdao를 inject 하세요	
	@Autowired
	private CustomerDAO customerDAO;
		

	@RequestMapping("/list")
	public String listCustomer(Model theModel) {
		
		//customers라는 이름으로 customerDAO의 return값을 받아오도록 코딩하세요.
		List<Customer> theCustomers = customerDAO.getCustomers();		

		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}	
}