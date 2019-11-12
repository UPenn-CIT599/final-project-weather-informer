
import java.text.DecimalFormat;

public class WeatherResponseFormatter {

	private static double convertToFahrenheit(double kelvin) {
		return ((kelvin - 273.15) * 9.0 / 5.0) + 32.0;
	}

	private static double convertToCelsius(double kelvin) {
		return (kelvin - 273.15);
	}

	public static void main(String args[]) {

		DecimalFormat formatter = new DecimalFormat("#0.00");

		double kelvin = 290.93809809;
		double celsius;
		double fahrenhiet;

		celsius = convertToCelsius(kelvin);

		fahrenhiet = convertToFahrenheit(kelvin);

		System.out.println(formatter.format(kelvin) + "\u00B0K = " + formatter.format(celsius) + "\u00B0C");

		System.out.println(formatter.format(kelvin) + "\u00B0K = " + formatter.format(fahrenhiet) + "\u00B0F");
	}

}
