package com.parkmobile.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parkmobile.app.entity.Ticket;
import com.parkmobile.app.service.LoginService;
import com.parkmobile.app.service.TicketService;

@RestController
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@RequestMapping(value = "ticket/{token}", method = RequestMethod.PUT)
	public Ticket scanTicket(@RequestParam("token") final String token) {
		
		return ticketService.scanTicket("to_be_replaced", token);
	}
}
