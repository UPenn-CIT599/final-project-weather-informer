package FinalProject.FinalProject;

public class ClothingRecommender {

    public String recommendClothesByTemp(Float temp){
        String wear ="";
        if(temp>293){
             wear = "It is going to be warm today. Wearing a T-shirt would be good.";
        }else if(temp<=293 && temp> 283){
             wear= "It is not going to be very cold today. Wearing a hoodie would be good.";
        }else{
             wear ="It is going to be cold today. Wearing a jacket would be good.";
        }
        return wear;
    }
    
    public String recommendByRain(String main){
        if(main.equals("Rain")){
            return "Bring an umbrella! It is going to be rainy today.";
        }else{
            return "No need to bring a umbrella! It is a sunny today :)";
        }
    }

}
