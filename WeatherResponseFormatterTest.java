import static org.junit.Assert.*;

import org.junit.Test;

public class WeatherResponseFormatterTest {

	@Test
	public void testConvertToFahrenheit() {
		double actualTemp = WeatherResponseFormatter.convertToFahrenheit(300);
		double expectedTemp = 80.33;
		assertEquals(expectedTemp, actualTemp, 1);

	}
	public void testConvertToCelsius() {
		double actualTemp = WeatherResponseFormatter.convertToCelsius(300);
		double expectedTemp = 80.33;
		assertEquals(expectedTemp, actualTemp, 1);

	}
}
