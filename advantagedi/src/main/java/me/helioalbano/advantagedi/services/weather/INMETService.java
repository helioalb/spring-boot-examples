package me.helioalbano.advantagedi.services.weather;

import me.helioalbano.advantagedi.services.satellites.Satellite;

// INMET = Instituto nacional de meteorologia
public class INMETService implements WeatherService {
	private Satellite satellite;

	public INMETService(Satellite satellite) {
		this.satellite = satellite;
	}

	@Override
	public Boolean willRain() {
		return satellite.numberOfClouds() > 5;
	}
}
