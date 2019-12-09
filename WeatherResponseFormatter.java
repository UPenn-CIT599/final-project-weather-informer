package finalproject.finalproject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.HashMap;

/**
 * Formats the weather response from Weather API such that it's human readable.
 */
public class WeatherResponseFormatter {

	/**
	 * Returns a map of weather attributes to their values from the string
	 * representation of a JSON response.
	 * 
	 * @param myResponse string form of a JSON object
	 * @return a map of weather attributes to their values
	 */
	public HashMap<String, Object> getFormattedResponse(String myResponse) {
		JsonObject jobj = new Gson().fromJson(myResponse, JsonObject.class);
		JsonObject weatherAll = (JsonObject) jobj.getAsJsonArray("weather").get(0);
		String main = weatherAll.get("main").toString();
		main = main.replace("\"", "");
		String description = weatherAll.get("description").toString();
		description = description.replace("\"", "");
		JsonObject temp_all = jobj.getAsJsonObject("main");
		Float temp = temp_all.get("temp").getAsFloat();
		Float humidity = temp_all.get("humidity").getAsFloat();
		Float clouds = jobj.getAsJsonObject("clouds").get("all").getAsFloat();
		String cityname = jobj.get("name").toString();
		cityname = cityname.replace("\"", "");
		HashMap<String, Object> weatherMap = new HashMap<String, Object>();
		weatherMap.put("main", main);
		weatherMap.put("description", description);
		weatherMap.put("temp", temp);
		weatherMap.put("humidity", humidity);
		weatherMap.put("clouds", clouds);
		weatherMap.put("cityname", cityname);

		return weatherMap;
	}

	/**
	 * Converts the given temperature from Kelvin to Fahrenheit.
	 * 
	 * @param kelvin temperature in Kelvin
	 * @return temperature in Fahrenheit
	 */
	public static double convertToFahrenheit(float kelvin) {
		return ((kelvin - 273.15) * 9.0 / 5.0) + 32.0;
	}

	/**
	 * Converts the given temperature from Kelvin to Celsius.
	 * 
	 * @param kelvin temperature in Kelvin
	 * @return temperature in Celsius
	 */
	public static double convertToCelsius(float kelvin) {
		return (kelvin - 273.15);
	}

	/**
	 * Formats and returns a human-readable string of current weather.
	 * 
	 * @return Well formatted string for current weather
	 */
	public String currentWeatherPrettyPrintStr(HashMap<String, Object> weatherMap) {
		String cityname = (String) weatherMap.get("cityname");
		String description = (String) weatherMap.get("description");
		Float temp = (Float) weatherMap.get("temp");
		Double tempC = convertToCelsius(temp);
		Double tempF = convertToFahrenheit(temp);
		Float humidity = (Float) weatherMap.get("humidity");
		Float clouds = (Float) weatherMap.get("clouds");

		String output = String.format(
				"\n\nThe current weather for %s is:\n\n\tTemperature: %.1f Fahrenheit (%.1f Celsius)"
						+ "\n\tHumidity: %.0f%%" + "\n\tCloud cover: %.0f%% with %s",
				cityname, tempF, tempC, humidity, clouds, description);

		return output;
	}

	/**
	 * Formats and returns a string of comparison of the chosen city with the user's
	 * city.
	 * 
	 * @return Well formatted string of comparison
	 */
	public String comparisonPrettyPrintStr(String userCurrentCity, String userSelectedCity, Float largetThanTemp,
			Float largetThanHum, Float lessThanCloud, Float maxTemp, Float minTemp, Double std) {
		Double maxTempC = convertToCelsius(maxTemp);
		Double minTempC = convertToCelsius(minTemp);

		String temperature = String.format(
				"\nToday's temperature in %s is higher than %.1f%% of the days in %s over the past year.",
				userCurrentCity, largetThanTemp * 100, userSelectedCity);
		String humidity = String.format(
				"\nToday's humidity in %s is lower than %.1f%% of the days in %s over the past year.", userCurrentCity,
				largetThanHum * 100, userSelectedCity);
		String cloudCover = String.format(
				"\nToday's cloud cover in %s is less than %.1f%% of the days in %s over the past year.",
				userCurrentCity, lessThanCloud * 100, userSelectedCity);
		String highestTemp = String.format("\nThe highest temperature in %s over the past year was %.1f Celsius.",
				userSelectedCity, maxTempC);
		String lowestTemp = String.format("\nThe lowest temperature in %s over the past year was %.1f Celsius.",
				userSelectedCity, minTempC);
		String stdDev = String.format("\nThe standard deviation of temperature last year in %s was %.1f Celsius.",
				userSelectedCity, std);

		return temperature + humidity + cloudCover + highestTemp + lowestTemp + stdDev;
	}
}
