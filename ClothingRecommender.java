package finalproject.finalproject;

/**
 * Recommends clothing given temperature and rain possibilities.
 */
public class ClothingRecommender {

	/**
	 * Returns a string telling what clothing to choose depending on the input temperature.
	 *
	 * @param temp current temperature
	 * @return recommendation string
	 */
	public String recommendClothesByTemp(Float temp) {
		String wear = "";
		if (temp > 293) {
			wear = "\nLooks like it's warm right now. Wearing a T-shirt should be fine.";
		} else if (temp <= 293 && temp > 283) {
			wear = "\nLooks like it isn't very cold right now. Wearing a hoodie should be fine.";
		} else {
			wear = "\nLooks like it's cold right now. We recommend wearing a jacket.";
		}
		return wear;
	}

	/**
	 * Returns a recommendation string as to whether to carry an umbrella or not.
	 *
	 * @param rain whether it's raining or not
	 * @return recommendation string
	 */
	public String recommendByRain(String rain) {
		if (rain.equals("Rain")) {
			return "\nDon't forget to take an umbrella! Looks like it might rain.";
		} else {
			return "\nNo need to take an umbrella! Rain isn't expected at the moment. :)\n";
		}
	}

}
