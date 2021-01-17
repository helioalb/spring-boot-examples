package me.helioalbano.advantagedi.airport;

import me.helioalbano.advantagedi.services.weather.WeatherService;

public class GRUAirport implements Airport {

	private WeatherService weather;

	public GRUAirport(WeatherService weather) {
		this.weather = weather;
	}

	@Override
	public Boolean isOpen() {
		return !weather.willRain();
	}

}
