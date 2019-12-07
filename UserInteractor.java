package FinalProject.FinalProject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class UserInteractor {
	/**
	 * attribute:
	 * static Scanner userIn 
	 * - take in user input
	 * 
	 * methods:
	 * userInteractorRunner()
	 * - top method to run UserInteractor
	 * 
	 * public static String getZipcodeFromUser()
	 * - get zipcode from user
	 * 
	 * public static String getEmailAddressFromUser()
	 * - get email address from user
	 */
	
	static Scanner userIn = new Scanner(System.in);

	public void userInteractorRunner() {
		BackendInteractor i = new BackendInteractor();
		String zipCode = getZipcodeFromUser();
		System.out.println("Thank you! We will soon send you a weather update for " + zipCode);
		HashMap<String,Object> weatherMap = i.getWeatherInfo(zipCode);
		String currentWeatherInfo = i.currentWeather(weatherMap);
		String clothingRecommended = i.clothingRecommendation(weatherMap);
		System.out.println(currentWeatherInfo);
		System.out.println(clothingRecommended);
		System.out.println("");
		System.out.println(
				"There are five cities you can choose to compare with your city, pelease input the number of city bellow:");
		System.out.println("1. New York  2.Chicago  3.Houston  4.Los Angeles  5.Philadelphia");
		String userSelectedNum  = userIn.next();
		// Might need some exception handling here for user input num
		String dataAnalysisResult = i.dataAnalysisResult(weatherMap, userSelectedNum);
		System.out.println(dataAnalysisResult);
		System.out.println("");
		String emailAddress = getEmailAddressFromUser();
		userIn.close();
		String emailBody = currentWeatherInfo + clothingRecommended + dataAnalysisResult;
		i.sendEmail(emailAddress, emailBody);
	}
	
	public static String getZipcodeFromUser() {
		String zipCode; // 5 digit zipCode
		do {
			System.out.print("Enter a valid 5 digit zip code in the USA for weather update: ");
			while (!userIn.hasNextInt()) {
				System.out.println("Invalid Zip Code. Please enter a valid 5 digit zip code in the USA");
				userIn.nextLine();
			}
			zipCode = userIn.next();

			// checks if the zipCode has 5 digits
		} while (zipCode.length() != 5);
		return zipCode;
	}

	public static String getEmailAddressFromUser() {

		String testString;

		String emailAddress;

		boolean b = false;

		do {

			System.out.println("Please enter your email address to get the weather information on your email.");

			emailAddress = userIn.next();

			// Validates email address

			String email_regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

			testString = emailAddress;

			b = testString.matches(email_regex);

			if (!b) {
				
				System.out.println("Please enter a valid email address.");
				
			}

		} while (!b);

		System.out.println("\n" + "We will soon send weather information to " + emailAddress);

		return emailAddress;

	}

}