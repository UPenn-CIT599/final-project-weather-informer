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

    public Float largerThanTempPrecentage(ArrayList<Float> arr_temp){
        Float cnt = 0.0f;
        for(int i = 0;i<arr_temp.size();i++){
            if(temp>arr_temp.get(i)+273.15f){
                cnt++;
            }
        }
        Float res = cnt/arr_temp.size();
        return res;
    }

    public Float largerThanHumPrecentage(ArrayList<Float> arr_hum){
        Float cnt = 0.0f;
        for(int i = 0;i<arr_hum.size();i++){
            if(hum>arr_hum.get(i)){
                cnt++;
            }
        }
        Float res = cnt/arr_hum.size();
        return res;
    }

    public Float lessThanCloudPrecentage(ArrayList<Float> arr_cloud){
        Float cnt = 0.0f;
        for(int i = 0;i<arr_cloud.size();i++){
            if(cloud<arr_cloud.get(i)){
                cnt++;
            }
        }
        Float res = cnt/arr_cloud.size();
        return res;
    }

    public Float highestTemp(ArrayList<Float> arr_temp){
        Float temp = 0.0f;
        for(int i = 0;i<arr_temp.size();i++){
            if(temp<arr_temp.get(i)+273.15f){
                temp = arr_temp.get(i)+273.15f;
            }
        }
        return temp;
    }

    public Float lowestTemp(ArrayList<Float> arr_temp){
        Float temp = arr_temp.get(0)+273.15f;
        for(int i = 0;i<arr_temp.size();i++){
            if(temp>arr_temp.get(i)+273.15f){
                temp = arr_temp.get(i)+273.15f;
            }
        }
        return temp;
    }

    public Double standartD(ArrayList<Float> arr_temp){
        Float sum = 0.0f;
        for(int i=0;i<arr_temp.size();i++){
            sum += arr_temp.get(i);      //求出数组的总和
        }
        //System.out.println(sum);  //939
        Float average = sum/arr_temp.size();  //求出数组的平均数
        //System.out.println(average);   //52.0
        Float total=0.0f;
        for(int i=0;i<arr_temp.size();i++){
            total += (arr_temp.get(i)-average)*(arr_temp.get(i)-average);   //求出方差，如果要计算方差的话这一步就可以了
        }
        Double standardDeviation = Math.sqrt(total/arr_temp.size());
        return standardDeviation;

    }

}

