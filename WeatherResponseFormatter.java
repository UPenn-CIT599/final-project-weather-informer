package query_weather;


public class WeatherResponseFormatter {

	public static double convertToFahrenheit(double kelvin) {
		return ((kelvin - 273.15) * 9.0 / 5.0) + 32.0;
	}

	public static double convertToCelsius(double kelvin) {
		return (kelvin - 273.15);
	}


}


