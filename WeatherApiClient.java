package FinalProject.FinalProject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


public class WeatherApiClient {
	/**
	 * This is the class to make query to the WeatherAPI and return the json response.
	 * 
	 * Attributes: 
	 * String query; => query
	 * String id; => api key for authentication
	 * String url; => weather api url
	 *
	 * Methods:
	 * public String getWeatherResponse()
	 * Makes the API call with query, returns the json response
	 */
	String query;
	String id;
	String url;
	
	public WeatherApiClient(String zipcode) {
		query = zipcode+",us";
		id = "4aa745966231c7801a54adb9e7e815d4";
		url = "http://api.openweathermap.org/data/2.5/weather?"+"appid="+id+"&zip="+query;
	}
	
	public String getWeatherResponse(){
		String responseBody = "";
		try {
			URLConnection connection = new URL(url).openConnection();	
				try {
					InputStream response;
					response = connection.getInputStream();
					try (Scanner scanner = new Scanner(response)) {
					    responseBody = scanner.useDelimiter("\\A").next();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return responseBody;
	}
	
}

