package FinalProject.FinalProject;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.resource.Emailv31;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class EmailApiClient {
	MailjetClient client;
	MailjetRequest request;
	MailjetResponse response;
	
	public EmailApiClient(String address, String body){
		client = new MailjetClient("9adcc4050da6cbf15e97450a09b569f7", "1f088f7f8258e72f34dc9884e17ad42c",
				new ClientOptions("v3.1"));
		request = new MailjetRequest(Emailv31.resource).property(Emailv31.MESSAGES,
				new JSONArray().put(new JSONObject()
						.put(Emailv31.Message.FROM, new JSONObject().put("Email", "weatherinformer@turingstroopers.org")
								.put("Name", "Weather Informer"))
						.put(Emailv31.Message.TO,
								new JSONArray()
										.put(new JSONObject().put("Email", address).put("Name", "")))
						.put(Emailv31.Message.SUBJECT, "Weather Report!")
						.put(Emailv31.Message.TEXTPART, "My first Mailjet email")
						.put(Emailv31.Message.HTMLPART, body)
						.put(Emailv31.Message.CUSTOMID, "AppGettingStartedTest")));
	}
	public void postEmailRequest() {
		try {
			response = client.post(request);
		} catch (MailjetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MailjetSocketTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(response.getStatus());
		System.out.println(response.getData());
	}
}
