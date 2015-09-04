package fi.hatware.testi;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.objectify.cmd.Query;

import fi.hatware.paikka.Paikka;

@SuppressWarnings("serial")
public class ListaaLampotilatServlet extends HttpServlet {
	
	Log log = LogFactory.getLog(this.getClass());
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		String lampotila = "";
		Paikka paikka = null;
		List<Paikka> paikat = ofy().load().type(Paikka.class).filter("lahiosoite == ", "Pietiläntie").list();
		Paikka pietilantie = ofy().load().type(Paikka.class).filter("lahiosoite == ", "Pietiläntie").first().now();
		paikka = paikat.get(0);
		//lampotila = pietilantie.lukemat.iterator().next().toString();
		Collection<Double> lampotilat = pietilantie.lukemat;
		for (Iterator iterator = lampotilat.iterator(); iterator.hasNext();) {
			Double double1 = (Double) iterator.next();
			lampotila = lampotila + double1 + "\n";
		}
		/*
		for (Iterator iterator = paikat.iterator(); iterator.hasNext();) {
			Paikka paikka = (Paikka) iterator.next(); 
			responseText = responseText + paikka.lahiosoite;
		}*/
		resp.getWriter().println("Lämpötila = " + lampotila);
	}
}
