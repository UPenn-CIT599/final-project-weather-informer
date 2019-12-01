import java.io.*;
import java.util.ArrayList;

public class DataAnylsis {
    public static ArrayList<Float> arr_temp = new ArrayList<>();
    public static ArrayList<Float> arr_cloud = new ArrayList<>();
    public static ArrayList<Float> arr_hum = new ArrayList<>();

    public DataAnylsis(String filename) throws IOException {
        FileInputStream inputStream = new FileInputStream(filename);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        int i = 0;
        String str = null;
        while((str = bufferedReader.readLine()) != null)
        {
            if(i>6 && (i-4)%4==0){
                String[] temp = str.split(";");
                arr_temp.add(Float.parseFloat(temp[1].replace("\"", "")));
                if(temp[10].equals("\"no clouds\"")){
                    arr_cloud.add(0.0f);
                }
                else if(temp[10].equals("\"100%.\"")) {
                    arr_cloud.add(100.0f);
                }
                else if(temp[10].equals("\"\"")){
                    arr_cloud.add(50.0f);
                }
                else if(temp[10].substring(1,3).equals("Sk")){
                    arr_cloud.add(100.0f);
                }
                else{
                    arr_cloud.add(Float.parseFloat(temp[10].substring(1,3).replace(" ","")));
                }
                arr_hum.add(Float.parseFloat(temp[5].replace("\"", "")));
            }
            i++;

        }
    }
}
