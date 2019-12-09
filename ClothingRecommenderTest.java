package finalproject.finalproject;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

/**
 * Test class for ClothingRecommender.
 */
public class ClothingRecommenderTest {
	ClothingRecommender clothingRecommender;
	
	@Before
	public void setup() {
		clothingRecommender = new ClothingRecommender();
	}
	
	@Test
	public void testRecommendClothesByTemp() throws Exception {
		Float temp = 285.0f;
		String result1 = clothingRecommender.recommendClothesByTemp(temp);
		assertEquals(result1, "\nLooks like it isn't very cold right now. Wearing a hoodie should be fine.");
	}

	@Test
	public void testRecommendClothesByTemp1() throws Exception {
		Float temp = 295.0f;
		String result1 = clothingRecommender.recommendClothesByTemp(temp);
		assertEquals(result1, "\nLooks like it's warm right now. Wearing a T-shirt should be fine.");
	}

	@Test
	public void testRecommendClothesByTemp2() throws Exception {
		Float temp = 280.0f;
		String result1 = clothingRecommender.recommendClothesByTemp(temp);
		assertEquals(result1, "\nLooks like it's cold right now. We recommend wearing a jacket.");
	}

	@Test
	public void testRecommendByRain() throws Exception {
		String str = "Rain";
		String result2 = clothingRecommender.recommendByRain(str);
		assertEquals(result2, "\nDon't forget to take an umbrella! Looks like it might rain.");
	}

	@Test
	public void testRecommendByRain1() throws Exception {
		String str = "Sun";
		String result2 = clothingRecommender.recommendByRain(str);
		assertEquals(result2, "\nNo need to take an umbrella! Rain isn't expected at the moment. :)\n");
	}

}
