package FinalProject.FinalProject;

import java.io.*;
import java.util.ArrayList;

public class DataAnalysis {
	public ArrayList<Float> arrTemp = new ArrayList<Float>();
    public ArrayList<Float> arrCloud = new ArrayList<Float>();
    public ArrayList<Float> arrHum = new ArrayList<Float>();

    @SuppressWarnings("resource")
	public DataAnalysis(String filename) throws IOException {
        FileInputStream inputStream = new FileInputStream(filename);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        int i = 0;
        String str = null;
        while((str = bufferedReader.readLine()) != null)
        {
            if(i>6 && (i-4)%4==0){
                String[] temp = str.split(";");
                arrTemp.add(Float.parseFloat(temp[1].replace("\"", "")));
                if(temp[10].equals("\"no clouds\"")){
                    arrCloud.add(0.0f);
                }
                else if(temp[10].equals("\"100%.\"")) {
                    arrCloud.add(100.0f);
                }
                else if(temp[10].equals("\"\"")){
                    arrCloud.add(50.0f);
                }
                else if(temp[10].substring(1,3).equals("Sk")){
                    arrCloud.add(100.0f);
                }
                else{
                    arrCloud.add(Float.parseFloat(temp[10].substring(1,3).replace(" ","")));
                }
                arrHum.add(Float.parseFloat(temp[5].replace("\"", "")));
            }
            i++;

        }
    }
}
