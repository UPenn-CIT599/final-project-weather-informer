import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class DataMain {

    public static void main(String[] arg) throws IOException {
        Float lat =  37.39f;
        Float lon = -122.09f;
        Float temp = 281.68f;
        Float humidity = 81.0f;
        Float temp_min = 279.26f;
        Float temp_max = 284.26f;
        Float clouds = 90.0f;
        String city_name = "Mountain View";
        String main = "Rain";
        String description  = "light rain" ;

        HashMap<String, Object> hm = new HashMap<>();
        hm.put("lat", lat);
        hm.put("lon", lon);
        hm.put("main", main);
        hm.put("description", description);
        hm.put("temp", temp);
        hm.put("humidity", humidity);
        hm.put("temp_min", temp_min);
        hm.put("temp_max", temp_max);
        hm.put("clouds", clouds);
        hm.put("cityname", city_name);

        //System.out.println(hm.get("lat"));
       // System.out.println(hm.get("main"));

        //paste the codes under this line to the main function
// #-------------------------------------------------------------------------------------------
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

        ClothRecommendation cR = new ClothRecommendation();
        String clothRecommendation = cR.cloth((Float)hm.get("temp"));
        //System.out.println(clothRecommendation);

        Umbrella  umb = new Umbrella();
        String ifUmbrella = umb.cloth((String)hm.get("main"));
        //System.out.println(ifUmbrella);

        DataAnylsis dataAnylsis = new DataAnylsis(filename);
        //for(int i = 0;i<dataAnylsis.arr_temp.size();i++){
         //  System.out.println(dataAnylsis.arr_temp.get(i));

        //}
        //System.out.println(dataAnylsis.arr_temp.size());

        //for(int i = 0;i<dataAnylsis.arr_cloud.size();i++){
           // System.out.println(dataAnylsis.arr_cloud.get(i));

        //}
        //System.out.println(dataAnylsis.arr_cloud.size());

        //for(int i = 0;i<dataAnylsis.arr_hum.size();i++){
         //   System.out.println(dataAnylsis.arr_hum.get(i));
        //}
        //System.out.println(dataAnylsis.arr_hum.size());

        // larger than x% temp
        Compartion compartion = new Compartion((Float)hm.get("temp"),(Float)hm.get("humidity"),(Float)hm.get("clouds"));
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


    }




}
