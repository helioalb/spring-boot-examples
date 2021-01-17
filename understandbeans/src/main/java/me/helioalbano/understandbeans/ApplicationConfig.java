package me.helioalbano.understandbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.helioalbano.understandbeans.dao.ClientDao;
import me.helioalbano.understandbeans.dao.ClientDaoImpl;
import me.helioalbano.understandbeans.services.ClientService;
import me.helioalbano.understandbeans.services.ClientServiceImpl;

// Beans can be add to @Configuration classes

@Configuration
public class ApplicationConfig {
	
	@Bean
	public ClientService clientService1(ClientDao clientDao) {
		ClientService clientService = new ClientServiceImpl();
		clientService.setName("Client service 1");
		clientService.setClientDao(clientDao);
		
		return clientService;
	}
	
	@Bean
	public ClientService clientService2(ClientDao clientDao) {
		ClientService clientService = new ClientServiceImpl();
		clientService.setName("Client service 2");
		clientService.setClientDao(clientDao);
		
		return clientService;
	}
	
	@Bean 
	public ClientDao clientDao() {
		return new ClientDaoImpl();
	}
}
