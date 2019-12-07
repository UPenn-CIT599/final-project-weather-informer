package FinalProject.FinalProject;

import java.io.IOException;
import java.util.HashMap;

public class BackendInteractor {
	/**
	 * methods:
	 * 
	 * public HashMap<String,Object> getWeatherInfo(String zipcode)
	 * - create weatherApiClient instance, return weather result in HashMap
	 * 
	 * public String currentWeather(HashMap<String,Object> weatherMap
	 * - create weatherResponseFormatter instance, return String current weather from HashMap
	 * 
	 * String clothingRecommendation(HashMap<String,Object> weatherMap)
	 * - create clothingRecommender instance, return String clothing recommendation from HashMap
	 * 
	 * public String dataAnalysisResult(HashMap<String,Object> weatherMap, String userSelectedNum)
	 * - create DataAnalysisInstance instance with city (userSelectedNum), return result String
	 * 
	 * public void sendEmail(String address, String body)
	 * - create EmailApiClient instance, send email body to provided email address
	 */
	public HashMap<String,Object> getWeatherInfo(String zipcode) {
		WeatherApiClient newWeatherClient = new WeatherApiClient(zipcode);
		String jsonResponse = newWeatherClient.getWeatherResponse();
		WeatherResponseFormatter i = new WeatherResponseFormatter();
		HashMap<String,Object> weatherMap = i.getFormattedResponse(jsonResponse);
		return weatherMap;
	}
	
	public String currentWeather(HashMap<String,Object> weatherMap) {
		WeatherResponseFormatter k = new WeatherResponseFormatter();
		String output = k.currentWeatherPrettyPrintStr(weatherMap);
		return output;
	}
	
	public  String clothingRecommendation(HashMap<String,Object> weatherMap) {
		ClothingRecommender cR = new ClothingRecommender();
		String clothRecommendation = cR.recommendClothesByTemp((Float)weatherMap.get("temp"));
	    String ifUmbrella = cR.recommendByRain((String)weatherMap.get("main"));
		return clothRecommendation + ifUmbrella;
	}
	
	public void sendEmail(String address, String body) {
		EmailApiClient newEmailClient = new EmailApiClient(address, body);
		newEmailClient.postEmailRequest();
	}
	
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
            filename = "phila.csv";
            userSelectedCity = "Phila";
        }
		try {
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

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
}
