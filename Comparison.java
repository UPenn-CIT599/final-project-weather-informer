package FinalProject.FinalProject;

import java.util.ArrayList;

public class Comparison {
    Float temp;
    Float hum;
    Float cloud;
    public Comparison(Float temp,Float hum, Float cloud){
        this.temp = temp;
        this.hum = hum;
        this.cloud = cloud;
    }

    public Float largerThanTempPrecentage(ArrayList<Float> arrTemp){
        Float cnt = 0.0f;
        for(int i = 0;i<arrTemp.size();i++){
            if(temp>arrTemp.get(i)+273.15f){
                cnt++;
            }
        }
        Float res = cnt/arrTemp.size();
        return res;
    }

    public Float largerThanHumPrecentage(ArrayList<Float> arrHum){
        Float cnt = 0.0f;
        for(int i = 0;i<arrHum.size();i++){
            if(hum>arrHum.get(i)){
                cnt++;
            }
        }
        Float res = cnt/arrHum.size();
        return res;
    }

    public Float lessThanCloudPrecentage(ArrayList<Float> arrCloud){
        Float cnt = 0.0f;
        for(int i = 0;i<arrCloud.size();i++){
            if(cloud<arrCloud.get(i)){
                cnt++;
            }
        }
        Float res = cnt/arrCloud.size();
        return res;
    }

    public Float highestTemp(ArrayList<Float> arrTemp){
        Float temp = 0.0f;
        for(int i = 0;i<arrTemp.size();i++){
            if(temp<arrTemp.get(i)+273.15f){
                temp = arrTemp.get(i)+273.15f;
            }
        }
        return temp;
    }

    public Float lowestTemp(ArrayList<Float> arrTemp){
        Float temp = arrTemp.get(0)+273.15f;
        for(int i = 0;i<arrTemp.size();i++){
            if(temp>arrTemp.get(i)+273.15f){
                temp = arrTemp.get(i)+273.15f;
            }
        }
        return temp;
    }

    public Double standartD(ArrayList<Float> arrTemp){
        Float sum = 0.0f;
        for(int i=0;i<arrTemp.size();i++){
            sum += arrTemp.get(i);
        }
        //System.out.println(sum);  //939
        Float average = sum/arrTemp.size();
        //System.out.println(average);   //52.0
        Float total=0.0f;
        for(int i=0;i<arrTemp.size();i++){
            total += (arrTemp.get(i)-average)*(arrTemp.get(i)-average);
        }
        Double standardDeviation = Math.sqrt(total/arrTemp.size());
        return standardDeviation;

    }

}


