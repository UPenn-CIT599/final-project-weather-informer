package FinalProject.FinalProject;

public class ClothingRecommender {

    public String recommendClothesByTemp(Float temp){
        String wear ="";
        if(temp>293){
             wear = "Wearing a T-shirt would be good.";
        }else if(temp<=293 && temp> 283){
             wear= "Wearing a hoodie would be good.";
        }else{
             wear ="Wearing a jacket would be good.";
        }
        return wear;
    }
    
    public String recommendByRain(String main){
        if(main.equals("\"Rain\"")){
            return "Bring an umbrella! It is going to be rainy today.";
        }else{
            return "No need to bring a umbrella! It is a sunny today :)";
        }
    }

}
