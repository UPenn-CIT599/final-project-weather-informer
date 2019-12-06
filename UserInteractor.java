package FinalProject.FinalProject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;


public class UserInteractor {
	
	public static String getZipcodeFromUser() {
		
		Scanner userIn = new Scanner(System.in);
		String zipCode; // 5 digit zipCode
		
		do {
			System.out.print("Enter a valid 5 digit zip code in the USA for weather update: ");
			while (!userIn.hasNextInt()) {
				System.out.println("Invalid Zip Code. Please enter a valid 5 digit zip code in the USA");
				userIn.nextLine(); 			
			}
			zipCode = userIn.next();
			
			// checks if the zipCode has 5 digits
		} while (zipCode.length() != 5);
		System.out.println("Thank you! We will soon send you a weather update for " + zipCode);
		WeatherApiClient newQuery = new WeatherApiClient(zipCode);
		String myResponse = newQuery.getWeatherResponse();
		WeatherResponseFormatter i = new WeatherResponseFormatter();
		HashMap<String, Object> hm = i.getFormattedResponse(myResponse);
		//print entries in formatted response
		/*
		for (Entry<String, Object> mapElement: hm.entrySet()) { 
            String key = (String)mapElement.getKey(); 
            Object value = mapElement.getValue(); 
            System.out.println(key + " : " + value); 
        }
        */
		String currentWeather = i.getPrettyPrintStr();
		System.out.println(currentWeather);
		
		String cityname = (String)hm.get("cityname");
		ClothingRecommender cR = new ClothingRecommender();
	    String clothRecommendation = cR.recommend_clothes_by_temp((Float)hm.get("temp"));
	    System.out.println(clothRecommendation);
	    String ifUmbrella = cR.recommend_by_rain((String)hm.get("main"));
	    
	    System.out.println(ifUmbrella);
		String output ="";//only one interface to next person 
        String filename ="";
        String str1 ="";
        String selectedcity = "";
        System.out.println("There are five cities you can choose to compare with your city, pelease input the number of city bellow:");
        System.out.println("1. New York  2.Chicago  3.Houston  4.Los Angeles  5.Philadelphia");
        Scanner scan = new Scanner(System.in);
        if (scan.hasNext()) {
            str1 = scan.next();
        }
        if(str1.equals("1")){
            filename = "newyork.csv";
            selectedcity = "New York";
            
        }if(str1.equals("2")){
            filename = "chicago.csv";
            selectedcity = "Chicago";
        }
        if(str1.equals("3")){
            filename = "houston.csv";
            selectedcity = "Houston";
        }
        if(str1.equals("4")){
            filename = "losangeles.csv";
            selectedcity = "Los Angeles";
        }
        if(str1.equals("5")){
            filename = "phila.csv";
            selectedcity = "Phila";
        }
		try {
			DataAnalysis dataAnylsis = new DataAnalysis(filename);
			// larger than x% temp
	        Comparison compartion = new Comparison((Float)hm.get("temp"),(Float)hm.get("humidity"),(Float)hm.get("clouds"));
	        Float largetThanTemp = compartion.largerThanTempPrecentage(dataAnylsis.arr_temp);
	        // System.out.println(largetThanTemp);

	        // larger than y% hum
	        Float largetThanHum = compartion.largerThanHumPrecentage(dataAnylsis.arr_hum);
	       // System.out.println(largetThanHum);

	        //Current cloud cover < k% days in 2018
	        Float lessThanCloud = compartion.lessThanCloudPrecentage(dataAnylsis.arr_cloud);
	        //System.out.println(lessThanCloud);


	        //max temp
	        Float maxTemp = compartion.highestTemp(dataAnylsis.arr_temp);
	        //System.out.println(maxTemp);
	        // min temp
	        Float minTemp = compartion.lowestTemp(dataAnylsis.arr_temp);
	        //System.out.println(minTemp);
	        //std
	        Double std = compartion.standartD(dataAnylsis.arr_temp);
	        //System.out.println(std);
	        output = output + clothRecommendation +" " +ifUmbrella + "\n"+
	                "Today's temperature in " + cityname.replace("\"", "") + " is higher than "+ largetThanTemp*100+"% of the days in "+ selectedcity + " in 2018." + "\n"+ 
	        		"Today's humidity in " + cityname.replace("\"", "") + " is lower than "+ largetThanHum*100+"% of the days in " + selectedcity +" in 2018."+ "\n"+
	                "Today's cloud cover in " + cityname.replace("\"", "") + " is less than "+ lessThanCloud*100+"% of the days the days in " + selectedcity + " in 2018." + "\n" + 
	        		"The highest temperature of last year in "+ selectedcity + " is " + maxTemp+"K."+ "\n" +
	                "The lowest temperature of last year in " + selectedcity + " is "+ minTemp +"K."+  "\n" + 
	        		"The standard deviation of temperature last year in " + selectedcity + " is "+ std + "K.";

	        System.out.println(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userIn.close();
		return zipCode;
	}
	
}

