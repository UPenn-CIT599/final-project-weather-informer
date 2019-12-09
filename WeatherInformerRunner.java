package finalproject.finalproject;

import java.util.HashMap;

/**
 * The main runner class that runs the entire program. This co-ordinates with
 * other classes to get things done.
 */
public class WeatherInformerRunner {
	/**
	 * Main method that runs the program.
	 */
	public static void main(String args[]) {
		UserInteractor userInteractor = new UserInteractor();
		BackendInteractor backendInteractor = new BackendInteractor();
		WeatherResponseFormatter weatherFormatter = new WeatherResponseFormatter();

		// Welcome the user and greet them.
		userInteractor.greetUser();

		// Get a US zip code from the user.
		String zipCode = userInteractor.getZipcodeFromUser();

		// Get current weather for that zip code.
		HashMap<String, Object> weatherMap = backendInteractor.getWeatherInfo(zipCode);

		// Convert it to a pretty printable string.
		String currentWeatherString = weatherFormatter.currentWeatherPrettyPrintStr(weatherMap);

		// Print current weather out to the user.
		userInteractor.printToUser(currentWeatherString);

		// Get clothing recommendation for current weather.
		String clothingRecommendation = backendInteractor.clothingRecommendation(weatherMap);

		// Print clothing recommendation out to the user.
		userInteractor.printToUser(clothingRecommendation);

		// Get user's choice of city to compare to.
		String cityNumber = userInteractor.getUserSelectedCityNumber();

		// Call data analysis functions to get the analysis results.
		String dataAnalysisResults = backendInteractor.dataAnalysisResult(weatherMap, cityNumber);

		// Print the data analysis out to the user.
		userInteractor.printToUser(dataAnalysisResults);

		// Get email address from user.
		String userEmailAddress = userInteractor.getEmailAddressFromUser();

		// Format email body.
		String emailBody = userInteractor.formatEmailBody(currentWeatherString, clothingRecommendation,
				dataAnalysisResults);

		// Send email to the user.
		EmailApiClient newEmailClient = new EmailApiClient(userEmailAddress, emailBody);
		newEmailClient.postEmailRequest();
	}
}
