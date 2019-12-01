import java.util.Scanner;

public class UserInteractor {
	static Scanner userIn = new Scanner(System.in);

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
		System.out.println("Thank you! We will soon send you a weather update for " + zipCode + "\n");
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
