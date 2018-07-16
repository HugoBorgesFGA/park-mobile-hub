package com.parkmobile.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.parkmobile.app.entity.Establishment;
import com.parkmobile.app.repository.EstablishmentRepository;

@Component
public class DataInitializer 
implements ApplicationListener<ApplicationReadyEvent> {
	
	@Autowired
	private EstablishmentRepository establishments; 
	
	private void initializeEstablishments() {
		
		System.out.println("DataInitializer: creating establishments...");
		
		Establishment parkShopping = new Establishment();
		parkShopping.setId(1L);
		parkShopping.setName("Park Shopping");
		parkShopping.setUrl("http://api.parkshopping.com/");
		
		Establishment venancioShopping = new Establishment();
		venancioShopping.setId(2L);
		venancioShopping.setName("Venancio Shopping");
		venancioShopping.setUrl("http://api.venancio.com/");
		
		establishments.save(parkShopping);
		establishments.save(venancioShopping);
	}
	
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		initializeEstablishments();
	}
}