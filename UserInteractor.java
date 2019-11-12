import java.util.Scanner;

public class UserInteractor {
	
	public static String getZipcodeFromUser() {
		
		Scanner userIn = new Scanner(System.in);
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
		System.out.println("Thank you! We will soon send you a weather update for " + zipCode);
		userIn.close();
		return zipCode;
	}
	
}
		
		
		
