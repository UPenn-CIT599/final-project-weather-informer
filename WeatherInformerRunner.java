import java.text.DecimalFormat;

public class WeatherInformerRunner {

	public static void main(String args[]) {

		//Temperature in Kelvin is converted to Celsius and Fahrenheit
		
		DecimalFormat formatter = new DecimalFormat("#0.00");

		double kelvin = 300.765; // to be replaced with input from Weather API 
		double celsius;
		double fahrenheit;

		celsius = WeatherResponseFormatter.convertToCelsius(kelvin);

		fahrenheit = WeatherResponseFormatter.convertToFahrenheit(kelvin);

		System.out.println("The temperature of " + formatter.format(kelvin) + "\u00B0K is equivalent to " + formatter.format(celsius) + "\u00B0C");

		System.out.println("The temperature of " + formatter.format(kelvin) + "\u00B0K is equivalent to " + formatter.format(fahrenheit) + "\u00B0F" +"\n");
		
		//Returns Zipcode entered by user
		
		String Zipcode = UserInteractor.getZipcodeFromUser();
	}

	
	}
	
