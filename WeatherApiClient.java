package finalproject.finalproject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * API client to query the OpenWeatherMap API.
 */
public class WeatherApiClient {
	/**
	 * This is the class to make query to the WeatherAPI and return the json
	 * response.
	 * 
	 * Attributes: String query; => query String id; => api key for authentication
	 * String url; => weather api url
	 *
	 * Methods: public String getWeatherResponse() Makes the API call with query,
	 * returns the json response
	 */
	String query;
	String id;
	String url;

	public WeatherApiClient(String zipcode) {
		query = zipcode + ",us";
		id = "4aa745966231c7801a54adb9e7e815d4";
		url = "http://api.openweathermap.org/data/2.5/weather?" + "appid=" + id + "&zip=" + query;
	}

	/**
	 * Calls the Weather API to get current weather. The zip code is initialized in
	 * the constructor.
	 * 
	 * @return the responseBody as received from the Weather API
	 */
	public String getWeatherResponse() {
		String responseBody = "";
		try {
			URLConnection connection = new URL(url).openConnection();
			try {
				InputStream response;
				response = connection.getInputStream();
				Scanner scanner = new Scanner(response);
				responseBody = scanner.useDelimiter("\\A").next();
			} catch (FileNotFoundException e) {
				System.out.println("\nThis zip code may not exist. Exiting the program. Please re-run the program"
						+ " and enter a valid zip code.");
				System.exit(1);
			} catch (Exception e) {
				System.out.println("\nSomething went wrong while retrieving the current weather. Exiting the program.");
				System.exit(1);
			}
		} catch (MalformedURLException e) {
			System.out.println("\nSomething went wrong while retrieving the current weather. Exiting the program.");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("\nSomething went wrong while retrieving the current weather. Exiting the program.");
			System.exit(1);
		}
		return responseBody;
	}
}
