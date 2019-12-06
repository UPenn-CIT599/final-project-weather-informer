package FinalProject.FinalProject;

import java.io.IOException;
import java.util.HashMap;

public class BackendInteractor {
	private WeatherApiClient newWeatherClient;
	private EmailApiClient newEmailClient;
	
	public HashMap<String,Object> getWeatherInfo(String zipcode) {
		newWeatherClient = new WeatherApiClient(zipcode);
		String jsonResponse = newWeatherClient.getWeatherResponse();
		WeatherResponseFormatter i = new WeatherResponseFormatter();
		HashMap<String,Object> weatherMap = i.getFormattedResponse(jsonResponse);
		return weatherMap;
	}
	
	public String currentWeather(HashMap<String,Object> weatherMap) {
		String cityname = (String)weatherMap.get("cityname");
		String descirption = (String)weatherMap.get("description");
		Float temp = (Float)weatherMap.get("temp");
		Float humidity = (Float)weatherMap.get("humidity");
		Float clouds = (Float)weatherMap.get("clouds");
		String output = "Today in " + cityname.replace("\"", "") + " the temperture is " + temp + "K, humidity is "
				+ humidity + "% and cloud cover is " + clouds + "%. We will be having " + descirption.replace("\"", "") + ".";
		return output;
	}
	
	public  String clothingRecommendation(HashMap<String,Object> weatherMap) {
		ClothingRecommender cR = new ClothingRecommender();
		String clothRecommendation = cR.recommendClothesByTemp((Float)weatherMap.get("temp"));
	    String ifUmbrella = cR.recommendByRain((String)weatherMap.get("main"));
		return clothRecommendation + ifUmbrella;
	}
	
	public void sendEmail(String address, String body) {
		EmailApiClient i = new EmailApiClient(address, body);
		i.postEmailRequest();
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
	        Float largetThanTemp = comparison.largerThanTempPrecentage(dataAnylsis.arr_temp);
	        // larger than y% hum
	        Float largetThanHum = comparison.largerThanHumPrecentage(dataAnylsis.arr_hum);
	        //Current cloud cover < k% days in 2018
	        Float lessThanCloud = comparison.lessThanCloudPrecentage(dataAnylsis.arr_cloud);
	        //max temp
	        Float maxTemp = comparison.highestTemp(dataAnylsis.arr_temp);
	        //System.out.println(maxTemp);
	        // min temp
	        Float minTemp = comparison.lowestTemp(dataAnylsis.arr_temp);
	        //System.out.println(minTemp);
	        //std
	        Double std = comparison.standartD(dataAnylsis.arr_temp);
	        //System.out.println(std);
	        output = "Today's temperature in " + userCurrentCity + " is higher than "+ largetThanTemp*100+"% of the days in "+ userSelectedCity + " in 2018." + "\n"+ 
	        		"Today's humidity in " + userCurrentCity.replace("\"", "") + " is lower than "+ largetThanHum*100+"% of the days in " + userSelectedCity +" in 2018."+ "\n"+
	                "Today's cloud cover in " + userCurrentCity.replace("\"", "") + " is less than "+ lessThanCloud*100+"% of the days the days in " + userSelectedCity + " in 2018." + "\n" + 
	        		"The highest temperature of last year in "+ userSelectedCity + " is " + maxTemp+"K."+ "\n" +
	                "The lowest temperature of last year in " + userSelectedCity + " is "+ minTemp +"K."+  "\n" + 
	        		"The standard deviation of temperature last year in " + userSelectedCity + " is "+ std + "K.";

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
}
