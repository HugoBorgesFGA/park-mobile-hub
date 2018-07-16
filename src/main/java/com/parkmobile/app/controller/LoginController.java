package com.parkmobile.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parkmobile.app.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String performLogin(@RequestParam("user") final String user, 
							   @RequestParam("password") final String encryptedPassword) {
		
		if (loginService.performLogin(user, encryptedPassword)) {
			return encryptedPassword;
		}
		
		return null;
	}
}
