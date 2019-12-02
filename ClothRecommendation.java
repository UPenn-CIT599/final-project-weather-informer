public class ClothRecommendation {

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

}
