package FinalProject.FinalProject;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.HashMap;

public class WeatherResponseFormatter {
	/**
	 * This is the class to format the json response from WeatherAPI.
	 * 
	 * Methods:
	 * public HashMap<String, Object> getFormattedResponse(String myResponse)
	 * - takes the json String of the API response, write the fields and values into HashMap, returns the HashMap
	 * 
	 * public double convertToFahrenheit(float kelvin)
	 * - converts kelvin to Fahrenheit
	 * 
	 * public double convertToCelsius(float kelvin)
	 * - converts kelvin to Celsius
	 * 
	 * public String currentWeatherPrettyPrintStr(HashMap<String,Object> weatherMap)
	 * - return formatted String for currentWeather
	 * 
	 * public String comparisonPrettyPrintStr(String userCurrentCity, String userSelectedCity, Float largetThanTemp, Float largetThanHum, Float lessThanCloud, Float maxTemp, Float minTemp, Double std)
	 * - return formatted String for weather comparison
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
		HashMap<String,Object> weatherMap = new HashMap<String,Object>();
		weatherMap.put("main", main);
		weatherMap.put("description", description);
		weatherMap.put("temp", temp);
		weatherMap.put("humidity", humidity);
		weatherMap.put("clouds", clouds);
		weatherMap.put("cityname", cityname);
		
		return weatherMap;

	}
	
	public double convertToFahrenheit(float kelvin) {
		return ((kelvin - 273.15) * 9.0 / 5.0) + 32.0;
	}
	
	public double convertToCelsius(float kelvin) {
		return (kelvin - 273.15);
	}
	
	public String currentWeatherPrettyPrintStr(HashMap<String,Object> weatherMap) {
		String cityname = (String)weatherMap.get("cityname");
		String descirption = (String)weatherMap.get("description");
		Float temp = (Float)weatherMap.get("temp");
		Double tempC =  convertToCelsius(temp);
		Float humidity = (Float)weatherMap.get("humidity");
		Float clouds = (Float)weatherMap.get("clouds");
		String output = "Today in " + cityname + " the temperture is " + tempC + " Celsius, humidity is "
				+ humidity + "% and cloud cover is " + clouds + "%. We will be having " + descirption + ".";
		return output;
	}
	
	public String comparisonPrettyPrintStr(String userCurrentCity, String userSelectedCity, Float largetThanTemp, 
			Float largetThanHum, Float lessThanCloud, Float maxTemp, Float minTemp, Double std) {
		Double maxTempC = convertToCelsius(maxTemp);
		Double minTempC = convertToCelsius(minTemp);
		String output = "Today's temperature in " + userCurrentCity + " is higher than "+ largetThanTemp*100+"% of the days in "+ userSelectedCity + " in 2018." + "\n"+ 
        		"Today's humidity in " + userCurrentCity + " is lower than "+ largetThanHum*100+"% of the days in " + userSelectedCity +" in 2018."+ "\n"+
                "Today's cloud cover in " + userCurrentCity + " is less than "+ lessThanCloud*100+"% of the days the days in " + userSelectedCity + " in 2018." + "\n" + 
        		"The highest temperature of last year in "+ userSelectedCity + " is " + maxTempC+" Celsius."+ "\n" +
                "The lowest temperature of last year in " + userSelectedCity + " is "+ minTempC +" Celsius."+  "\n" + 
        		"The standard deviation of temperature last year in " + userSelectedCity + " is "+ std + "K.";
		return output;
	}
	
}


