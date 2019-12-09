package finalproject.finalproject;

import java.util.Scanner;

/**
 * This class is in-charge of user interactions. Accepts user input, formats and
 * prints out messages to the user on the screen.
 */
public class UserInteractor {

	Scanner userIn = new Scanner(System.in);

	/**
	 * Gets the zip code from user and returns it.
	 *
	 * @return zip code as entered by the user
	 */
	public String getZipcodeFromUser() {
		String zipCode; // 5 digit zipCode
		do {
			System.out.print("\nEnter a valid 5 digit zip code in the USA for weather update: ");
			while (!userIn.hasNextInt()) {
				System.out.println("Invalid Zip Code. Please enter a valid 5 digit zip code in the USA");
				userIn.nextLine();
			}
			zipCode = userIn.next();

			// checks if the zipCode has 5 digits
		} while (zipCode.length() != 5);

		return zipCode;
	}

	/**
	 * Gets the email address from the user and returns it.
	 * 
	 * @return email address as entered by the user
	 */
	public String getEmailAddressFromUser() {
		String testString;
		String emailAddress;
		boolean b = false;

		do {
			System.out.print("\n\nPlease enter a valid email address to get the weather information on your email: ");
			emailAddress = userIn.next();

			// Validates email address
			String email_regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
			testString = emailAddress;
			b = testString.matches(email_regex);

			if (!b) {
				System.out.println("\nInvalid email address - [" + emailAddress + "]");
			}
		} while (!b);

		System.out.println("\nWe will soon send weather information to [" + emailAddress + "]");
		return emailAddress;
	}

	/**
	 * Prints the welcome message for the program.
	 */
	public void greetUser() {
		System.out.println("\t\t***** Weather Informer *****\n");
		System.out.println("\tWelcome to the Weather Informer program.");
		System.out.println(
				"\tGiven a US zip code, we retrieve it's current weather in real-time using OpenWeatherMap API.");
		System.out.println(
				"\tWe then present you with options of 5 cities to compare the weather over the past 12 months.");
		System.out.println("\tAt the end, we ask you for your email address and send you the details over it.");
	}

	/**
	 * Prints the given string to the user screen.
	 */
	public void printToUser(String currentWeatherString) {
		System.out.println(currentWeatherString);
	}

	/**
	 * Presents choices of 5 cities to the user and accepts the user choice.
	 * 
	 * @return number of the city of user's choice (in String)
	 */
	public String getUserSelectedCityNumber() {
		System.out.println("\nThere are five cities you can choose from to compare with your city.");

		boolean userInputInvalid = true;
		String userSelectedNum;
		do {
			System.out.println("\n\t1. New York\n\t2. Chicago\n\t3. Houston\n\t4. Los Angeles\n\t5. Philadelphia");
			System.out.print("\nPlease enter the number of the city of your choice - ");
			userSelectedNum = userIn.next();
			if (!userSelectedNum.equals("1") && !userSelectedNum.equals("2") && !userSelectedNum.equals("3")
					&& !userSelectedNum.equals("4") && !userSelectedNum.equals("5")) {
				System.out.println("\nInvalid input. Please enter a valid input.");
				userInputInvalid = true;
			} else {
				userInputInvalid = false;
			}
		} while (userInputInvalid);

		return userSelectedNum;
	}

	/**
	 * Formats the body of the email to be sent.
	 * 
	 * @param currentWeatherString   weather information string
	 * @param clothingRecommendation clothing recommendation string
	 * @param dataAnalysisResults    data analysis string
	 * @return well formatted string ready to be sent as text email body
	 */
	public String formatEmailBody(String currentWeatherString, String clothingRecommendation,
			String dataAnalysisResults) {
		String header = "Hi,\nThis is your requested weather report from Weather Informer.";
		String footer = "\n\nThanks,\nTeam 6 - Weather Informer";

		return header + currentWeatherString + "\n" + clothingRecommendation + dataAnalysisResults + footer;
	}
}