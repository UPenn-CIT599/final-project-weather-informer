package query_weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class WeatherApiClient {
	String query;
	String id;
	String url;
	
	WeatherApiClient(String zipcode) {
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
