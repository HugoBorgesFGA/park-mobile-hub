package com.parkmobile.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkmobile.app.entity.User;
import com.parkmobile.app.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;
	
	public boolean performLogin(final String email, final String hashPassword) {
		
		final User user = userRepository.findByEmail(email);
		if (user == null) return false;
		
		if (! user.getPassword().equals(hashPassword)) return false;
		
		return true;
	}
}
