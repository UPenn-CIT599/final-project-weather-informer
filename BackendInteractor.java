package finalproject.finalproject;

import java.io.IOException;
import java.util.HashMap;

/**
 * Interacts with weather data related classes to get data for the program runner.
 */
public class BackendInteractor {
	/**
	 * Gets the weather info by calling weather api for a given zipcode.
	 * 
	 * @param zipcode the zipcode to retrieve weather for
	 * @return a map of weather attribute to it's value
	 */
	public HashMap<String,Object> getWeatherInfo(String zipcode) {
		WeatherApiClient newWeatherClient = new WeatherApiClient(zipcode);
		String jsonResponse = newWeatherClient.getWeatherResponse();
		WeatherResponseFormatter i = new WeatherResponseFormatter();
		HashMap<String,Object> weatherMap = i.getFormattedResponse(jsonResponse);
		return weatherMap;
	}
	
	/**
	 * Returns a clothing recommendation string based on the input weather.
	 * 
	 * @param weatherMap a map of weather attributes to values
	 * @return clothing recommendation string
	 */
	public  String clothingRecommendation(HashMap<String,Object> weatherMap) {
		ClothingRecommender cR = new ClothingRecommender();
		String clothRecommendation = cR.recommendClothesByTemp((Float)weatherMap.get("temp"));
	    String ifUmbrella = cR.recommendByRain((String)weatherMap.get("main"));
		return clothRecommendation + ifUmbrella;
	}
	
	/**
	 * Performs and returns the data analysis given weather map and the city number.
	 * 
	 * @param weatherMap a map of weather attributes to values
	 * @param userSelectedNum number corresponding to the city selected by the user
	 * @return string of the data analysis result
	 */
	public String dataAnalysisResult(HashMap<String,Object> weatherMap, String userSelectedNum) {
		String filename = "";
		String userSelectedCity = "";
		String userCurrentCity = (String)weatherMap.get("cityname");
		String output = "";
		Comparison comparison = new Comparison((Float)weatherMap.get("temp"),
				(Float)weatherMap.get("humidity"),
				(Float)weatherMap.get("clouds"));
		if(userSelectedNum.equals("1")){
            filename = "newyork.csv";
            userSelectedCity = "New York";
        }
		else if(userSelectedNum.equals("2")){
            filename = "chicago.csv";
            userSelectedCity = "Chicago";
        }
		else if(userSelectedNum.equals("3")){
            filename = "houston.csv";
            userSelectedCity = "Houston";
        }
        if(userSelectedNum.equals("4")){
            filename = "losangeles.csv";
            userSelectedCity = "Los Angeles";
        }
        if(userSelectedNum.equals("5")){
            filename = "philadelphia.csv";
            userSelectedCity = "Philadelphia";
        }
		DataAnalysis dataAnylsis = new DataAnalysis(filename);
		// larger than x% temp
		Float largetThanTemp = comparison.largerThanTempPrecentage(dataAnylsis.arrTemp);
		// larger than y% hum
		Float largetThanHum = comparison.largerThanHumPrecentage(dataAnylsis.arrHum);
		//Current cloud cover < k% days in 2018
		Float lessThanCloud = comparison.lessThanCloudPrecentage(dataAnylsis.arrCloud);
		//max temp
		Float maxTemp = comparison.highestTemp(dataAnylsis.arrTemp);
		//System.out.println(maxTemp);
		// min temp
		Float minTemp = comparison.lowestTemp(dataAnylsis.arrTemp);
		//System.out.println(minTemp);
		//std
		Double std = comparison.standartD(dataAnylsis.arrTemp);
		//System.out.println(std);
		WeatherResponseFormatter k = new WeatherResponseFormatter();
		output = k.comparisonPrettyPrintStr(userCurrentCity, userSelectedCity, largetThanTemp, 
				largetThanHum, lessThanCloud, maxTemp, minTemp, std);
		return output;
	}
}
