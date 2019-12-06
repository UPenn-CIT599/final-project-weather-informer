package query_weather;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class query_weather{
	
	public static void main(String[] args) {
		String zipcode = "99501";
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
		ClothingRecommender cR = new ClothingRecommender();
	    String clothRecommendation = cR.cloth((Float)hm.get("temp"));
	    System.out.println(clothRecommendation);
	    String ifUmbrella = cR.cloth((String)hm.get("main"));
	    
	    System.out.println(ifUmbrella);
		String output ="";//only one interface to next person 
        String filename ="";
        String str1 ="";
        System.out.println("There are five cities you can choose to compare with your city, pelease input the number of city bellow:");
        System.out.println("1. New York  2.Chicago  3.Houston  4.Los Angeles  5.Philadelphia");
        Scanner scan = new Scanner(System.in);
        if (scan.hasNext()) {
            str1 = scan.next();
        }
        if(str1.equals("1")){
            filename = "newyork.csv";
        }if(str1.equals("2")){
            filename = "chicago.csv";
        }
        if(str1.equals("3")){
            filename = "houston.csv";
        }
        if(str1.equals("4")){
            filename = "losangeles.csv";
        }
        if(str1.equals("5")){
            filename = "phila.csv";
        }

        DataAnalysis dataAnylsis;
		try {
			dataAnylsis = new DataAnalysis(filename);
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
	                "today is "+ largetThanTemp*100+"% warmer than 2018." + "\n"+ "today is "+ largetThanHum*100+"% wetter than 2018."+
	                "\n"+"today is less "+ lessThanCloud*100+"% cloudy than 2018." + "\n" + "The highest temperature of last year is "+
	                maxTemp+"K"+ "\n" + "The lowest temperature of last year is "+ minTemp +"K"+  "\n" + "The standard deviation " +
	                "temperature of last year is "+ std;

	        System.out.println(output);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
