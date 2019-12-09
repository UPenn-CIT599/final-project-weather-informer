package finalproject.finalproject;

import java.io.*;
import java.util.ArrayList;

/**
 * Class that reads the csv files and initiates data analysis.
 */
public class DataAnalysis {
	public ArrayList<Float> arrTemp = new ArrayList<Float>();
	public ArrayList<Float> arrCloud = new ArrayList<Float>();
	public ArrayList<Float> arrHum = new ArrayList<Float>();

	public DataAnalysis(String filename) {
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/finalproject/finalproject/" + filename);

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			int i = 0;
			String str = null;
			try {
				while ((str = bufferedReader.readLine()) != null) {
					if (i > 6 && (i - 4) % 4 == 0) {
						String[] temp = str.split(";");
						arrTemp.add(Float.parseFloat(temp[1].replace("\"", "")));
						if (temp[10].equals("\"no clouds\"")) {
							arrCloud.add(0.0f);
						} else if (temp[10].equals("\"100%.\"")) {
							arrCloud.add(100.0f);
						} else if (temp[10].equals("\"\"")) {
							arrCloud.add(50.0f);
						} else if (temp[10].substring(1, 3).equals("Sk")) {
							arrCloud.add(100.0f);
						} else {
							arrCloud.add(Float.parseFloat(temp[10].substring(1, 3).replace(" ", "")));
						}
						arrHum.add(Float.parseFloat(temp[5].replace("\"", "")));
					}
					i++;
				}
			} catch (NumberFormatException e) {
				System.out.println("Error occurred while reading the file. Exiting.");
				System.exit(1);
			} catch (IOException e) {
				System.out.println("Error occurred while reading the file. Exiting.");
				System.exit(1);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Trying to read file from location - " + System.getProperty("user.dir")
					+ "/src/main/java/finalproject/finalproject/" + filename);
			System.out.println("Could not find file. Make sure the filepath is correct. Exiting.");
			System.exit(1);
		}
	}
}
