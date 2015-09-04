package fi.hatware.testi;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import fi.hatware.paikka.Paikka;

@SuppressWarnings("serial")
public class TallennaPaikkaServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		
		Paikka pietilantie = ofy().load().type(Paikka.class).filter("lahiosoite == ", "Pietiläntie").first().now();
		if (pietilantie == null) pietilantie = new Paikka("Pietiläntie");
		pietilantie.lukemat.add(new Double(20.5));
		ObjectifyService.ofy().save().entity(pietilantie).now();
		
		resp.getWriter().println("Paikka tallennettu");
	}
}
