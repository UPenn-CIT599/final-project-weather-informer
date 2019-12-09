package finalproject.finalproject;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.resource.Emailv31;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * API client to to send email using MailJet API. This uses JSON to communicate.
 */
public class EmailApiClient {
	MailjetClient client;
	MailjetRequest request;
	MailjetResponse response;

	public EmailApiClient(String address, String body) {
		client = new MailjetClient("9adcc4050da6cbf15e97450a09b569f7", "1f088f7f8258e72f34dc9884e17ad42c",
				new ClientOptions("v3.1"));
		request = new MailjetRequest(Emailv31.resource).property(Emailv31.MESSAGES, new JSONArray().put(new JSONObject()
				.put(Emailv31.Message.FROM,
						new JSONObject().put("Email", "weatherinformer@turingstroopers.org").put("Name",
								"Weather Informer"))
				.put(Emailv31.Message.TO, new JSONArray().put(new JSONObject().put("Email", address).put("Name", "")))
				.put(Emailv31.Message.SUBJECT, "Weather Report from Weather Informer")
				.put(Emailv31.Message.TEXTPART, body).put(Emailv31.Message.CUSTOMID, "AppGettingStartedTest")));
	}

	/**
	 * Sends the email request.
	 */
	public void postEmailRequest() {
		try {
			response = client.post(request);
		} catch (MailjetException e) {
			System.out.println("\nLooks like there were problems sending the email. The email API that we use"
					+ " may be down. Please try again later.");
		} catch (MailjetSocketTimeoutException e) {
			System.out.println("\nLooks like there were problems sending the email. The email API that we use"
					+ " may be down. Please try again later.");
		}
		if (response.getStatus() == 200) {
			System.out.println("\nWe were successful in sending an email with the weather information!");
			System.out.println("Thank you for using Weather Informer! :)");
		} else {
			System.out.println("\nLooks like there were problems sending the email. The email API that we use"
					+ " may be down. Please try again later.");
		}
	}
}
