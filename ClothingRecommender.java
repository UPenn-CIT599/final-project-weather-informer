package query_weather;

public class ClothingRecommender {

    public String cloth(Float temp){
        String wear ="";
        if(temp>293){
             wear = "Wear T-shirt would be good.";
        }else if(temp<=293 && temp> 283){
             wear= "Wear hoody would be good.";
        }else{
             wear ="Wear jacket would be good.";
        }
        return wear;
    }
    
    public String cloth(String main){
        if(main.equals("Rain")){
            return "Bring a umbrella, today is a rainy day.";
        }else{
            return "No need to bring a umbrella, today is a sunny day.";
        }
    }

}
