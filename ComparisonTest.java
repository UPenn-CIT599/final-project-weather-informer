package finalproject.finalproject;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Test class for Comparison class.
 */
public class ComparisonTest {

	Comparison test1 = new Comparison(281.68f, 81.0f, 90.0f);
	ArrayList<Float> arrTemperature;
	ArrayList<Float> arrHumidity;
	ArrayList<Float> arrCloud;

	@Before
	public void setup() {
		arrTemperature = new ArrayList<Float>(Arrays.asList(8.0f, 14.0f, 21.5f, 33.5f, 38.0f));
		arrHumidity = new ArrayList<Float>(Arrays.asList(80f, 10f, 21f, 95f, 75f));
		arrCloud = new ArrayList<Float>(Arrays.asList(8f, 5f, 95f, 70f, 50f));
	}

	@Test
	public void testLargerThanTempPrecentage() throws Exception {

		Float largetThanTemp = test1.largerThanTempPrecentage(arrTemperature);

		assertEquals(largetThanTemp, 0.2f, 0.1);
	}

	@Test
	public void testLargerThanHumPrecentage() throws Exception {
		Float largetThanHum = test1.largerThanHumPrecentage(arrHumidity);

		assertEquals(largetThanHum, 0.77925533f, 0.1);

	}

	@Test
	public void testLessThanCloudPrecentage() throws Exception {
		Float lessThanCloud = test1.lessThanCloudPrecentage(arrCloud);

		assertEquals(lessThanCloud, 0.2819149f, 0.1);
	}

	@Test
	public void testHighestTemp() throws Exception {
		Float maxTemp = test1.highestTemp(arrTemperature);

		assertEquals(maxTemp, 311.15f, 0.01);
	}

	@Test
	public void testLowestTemp() throws Exception {
		Float minTemp = test1.lowestTemp(arrTemperature);

		assertEquals(minTemp, 281.15f, 0.01);
	}

	@Test
	public void testStandartD() throws Exception {
		Double std = test1.standartD(arrTemperature);

		assertEquals(std, 11.35f, 0.1);
	}
}
