package me.helioalbano.understandbeans;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import me.helioalbano.understandbeans.services.ClientService;

@SpringBootApplication
public class UnderstandbeansApplication {

	@Autowired
	@Qualifier("clientService1")
	private ClientService service1;
	
	@Autowired
	@Qualifier("clientService2")
	private ClientService service2;
	
	public static void main(String[] args) {
		SpringApplication.run(UnderstandbeansApplication.class, args);
	}

	@PostConstruct
	public void init() {
		System.out.println("Service name: " + service1.getName());
		System.out.println("Dao from " + service1.getName() + ": " + service1.getClientDao().getName());
		
		System.out.println("------------------------------------");
		
		System.out.println("Service name: " + service2.getName());
		System.out.println("Dao from " + service2.getName() + ": " + service2.getClientDao().getName());
	}
}
