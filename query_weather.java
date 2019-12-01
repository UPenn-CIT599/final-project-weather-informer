package query_weather;

import java.util.HashMap;
import java.util.Map.Entry;

public class query_weather{
	
	public static void main(String[] args) {
		String zipcode = "94040";
		WeatherApiClient newQuery = new WeatherApiClient(zipcode);
		String myResponse = newQuery.getWeatherResponse();
		System.out.println(myResponse);
		FormattedResponse i = new FormattedResponse();
		HashMap<String, Object> hm = i.getFormattedResponse(myResponse);
		// print entries in formatted response
		for (Entry<String, Object> mapElement: hm.entrySet()) { 
            String key = (String)mapElement.getKey(); 
            Object value = mapElement.getValue(); 
            System.out.println(key + " : " + value); 
        } 
	}
}
