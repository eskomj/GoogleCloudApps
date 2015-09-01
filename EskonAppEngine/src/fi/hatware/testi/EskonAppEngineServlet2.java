package fi.hatware.testi;

import java.io.IOException;
import javax.servlet.http.*;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



@SuppressWarnings("serial")
public class EskonAppEngineServlet2 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
		Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        String msgBody = "Sähköpostiviesti";

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("esko.jaakkola@gmail.com", "Esko Jaakkola"));
            msg.addRecipient(Message.RecipientType.TO,
                             new InternetAddress("esko.jaakkola@tulli.fi", "Esko Jaakkola"));
            msg.setSubject("Your Example.com account has been activated");
            msg.setText(msgBody);
            Transport.send(msg);

        } catch (AddressException e) {
            // ...
        } catch (MessagingException e) {
            // ...
        }

		resp.getWriter().println("email sent!");
	}
}
