package finalproject.finalproject;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for WeatherResponseFormatter.
 */
public class WeatherResponseFormatterTest {

	@Test
	public void testConvertToFahrenheit() {
		double actualTemp = WeatherResponseFormatter.convertToFahrenheit(300);
		double expectedTemp = 80.33;
		assertEquals(expectedTemp, actualTemp, 1);
	}
	
	@Test
	public void testConvertToCelsius() {
		double actualTemp = WeatherResponseFormatter.convertToCelsius(300);
		double expectedTemp = 26.85;
		assertEquals(expectedTemp, actualTemp, 1);
	}
}
