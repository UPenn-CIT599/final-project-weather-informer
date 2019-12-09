package finalproject.finalproject;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Test class for WeatherApiClient.
 */
public class WeatherApiClientTest {

	@Test
	public void testGetWeatherResponse() {
		WeatherApiClient test = new WeatherApiClient("95054");
		String output = test.getWeatherResponse();
		assertNotNull(output);
	}
}
