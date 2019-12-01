package query_weather;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.HashMap;

public class FormattedResponse {
	private HashMap<String, Object> weatherMap;
	
	FormattedResponse(){
		weatherMap = new HashMap<String,Object>();
	}
	
	public HashMap<String, Object> getFormattedResponse(String myResponse) {
		JsonObject jobj = new Gson().fromJson(myResponse, JsonObject.class);
		Float lat = jobj.getAsJsonObject("coord").get("lat").getAsFloat();
		Float lon = jobj.getAsJsonObject("coord").get("lon").getAsFloat();
		JsonObject weather_all = (JsonObject) jobj.getAsJsonArray("weather").get(0);
		String main = weather_all.get("main").toString();
		String description = weather_all.get("description").toString();
		JsonObject temp_all = jobj.getAsJsonObject("main");
		Float temp = temp_all.get("temp").getAsFloat();
		Float humidity = temp_all.get("humidity").getAsFloat();
		Float temp_min = temp_all.get("temp_min").getAsFloat();
		Float temp_max = temp_all.get("temp_max").getAsFloat();
		Float clouds = jobj.getAsJsonObject("clouds").get("all").getAsFloat();
		String city_name = jobj.get("name").toString();
		
		weatherMap.put("lat", lat);
		weatherMap.put("lon", lon);
		weatherMap.put("main", main);
		weatherMap.put("description", description);
		weatherMap.put("temp", temp);
		weatherMap.put("humidity", humidity);
		weatherMap.put("temp_min", temp_min);
		weatherMap.put("temp_max", temp_max);
		weatherMap.put("clouds", clouds);
		weatherMap.put("cityname", city_name);
		
		return weatherMap;
		
	}
}
