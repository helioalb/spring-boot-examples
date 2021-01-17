package me.helioalbano.advantagedi;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import me.helioalbano.advantagedi.airport.Airport;
import me.helioalbano.advantagedi.airport.GRUAirport;
import me.helioalbano.advantagedi.services.satellites.Satellite;
import me.helioalbano.advantagedi.services.satellites.SatelliteX;
import me.helioalbano.advantagedi.services.weather.INMETService;
import me.helioalbano.advantagedi.services.weather.WeatherService;

@SpringBootApplication
public class AdvantagediApplication {

	@Bean
	public Satellite satellite() {
		return new SatelliteX();
	}
	
	@Bean
	public WeatherService weather(Satellite satellite) {
		return new INMETService(satellite);
	}
	
	@Bean
	public Airport airport(WeatherService weatherService) {
		return new GRUAirport(weatherService);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AdvantagediApplication.class, args);
		

		
//		Aproach without spring
//		
//		Satellite satellite = new SatelliteX();
//		WeatherService weatherService = new INMETService(satellite);
//		Airport gru = new GRUAirport(weatherService);
//		
//		System.out.println("De acordo com a previsão do tempo o Aeroporto encontra-se:");
//		
//		if (gru.isOpen()) {
//			System.out.println("Aberto");
//		} else {
//			System.out.println("Fechado");
//		}
	}

	@Autowired
	public Airport airport;
	
	@PostConstruct
	public void init() {
		System.out.println("De acordo com a previsão do tempo o Aeroporto encontra-se:");
		
		if (airport.isOpen()) {
			System.out.println("Aberto");
		} else {
			System.out.println("Fechado");
		}	
	}
}
