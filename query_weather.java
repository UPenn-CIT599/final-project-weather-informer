package query_weather;
import java.io.FileReader; 
import java.util.Iterator; 
import java.util.Map;

public class query_weather{
	
	public static void main(String[] args) {
		String zipcode = "94040";
		WeatherApiClient newQuery = new WeatherApiClient(zipcode);
		String myResponse = newQuery.getWeatherResponse();
		System.out.println(myResponse);
	}
}
