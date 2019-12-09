package finalproject.finalproject;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for UserInteractor.
 */
public class UserInteractorTest {
	UserInteractor userInteractor;

	@Before
	public void setup() {
		userInteractor = new UserInteractor();
	}

	@Test
	public void testFormatEmailBody() {
		String currentWeatherString = "This is a dummy weather string";
		String clothingRecommendation = "This is a dummy clothing recommendation";
		String dataAnalysisResults = "This is a dummy Data analysis result string";
		String expectedEmailBody = "Hi,\n" + 
				"This is your requested weather report from Weather Informer.This is a dummy weather string\n" + 
				"This is a dummy clothing recommendationThis is a dummy Data analysis result string\n" + 
				"\n" + 
				"Thanks,\n" + 
				"Team 6 - Weather Informer";
		
		String actualEmailBody = userInteractor.formatEmailBody(currentWeatherString, clothingRecommendation,
				dataAnalysisResults);
		System.out.println(actualEmailBody);
		
		assertEquals(actualEmailBody, expectedEmailBody);
	}

}
