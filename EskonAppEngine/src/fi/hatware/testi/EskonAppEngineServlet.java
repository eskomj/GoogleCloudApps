package fi.hatware.testi;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.*;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Account;

@SuppressWarnings("serial")
public class EskonAppEngineServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
		String ACCOUNT_SID = "ACb5042e0b3bc6ccb4031afba516dffb0b";
		String AUTH_TOKEN = "3dc8a2ba4414d15e1e51f37f444a217c";

		// Create a rest client
		final TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

		// Get the main account (The one we used to authenticate the client)
		final Account mainAccount = client.getAccount();

		// Send a text message
		final SmsFactory smsFactory = mainAccount.getSmsFactory();
		final Map<String, String> smsParams = new HashMap<String, String>();
		smsParams.put("To", "+358403326803"); // The number to send the text to
		smsParams.put("From", "+3584573963706"); // A Twilio number you purchased
		smsParams.put("Body", "This is a test message!");
		try {
			smsFactory.create(smsParams);
		} catch (TwilioRestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resp.getWriter().println("text sent!");
	}
}
