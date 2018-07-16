package com.parkmobile.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkmobile.app.entity.Establishment;
import com.parkmobile.app.entity.Ticket;
import com.parkmobile.app.entity.User;
import com.parkmobile.app.repository.EstablishmentRepository;
import com.parkmobile.app.repository.TicketRepository;
import com.parkmobile.app.repository.UserRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository tickets;
	
	@Autowired
	private EstablishmentRepository establishments;
	
	@Autowired
	private UserRepository users;
	
	public Ticket scanTicket(final String userAUth, final String ticket) {
		
		final String establishmenId = ticket.substring(0, 4);
		final Establishment establishment = establishments.getOne(Long.valueOf(establishmenId));
		
		final User user = users.findByPassword(userAUth);
		
		Ticket token = new Ticket();
		token.setEstablishment(establishment);
		token.setToken(ticket);
		token.setUser(user);
		
		tickets.save(token);
		
		return token;
	}
}
