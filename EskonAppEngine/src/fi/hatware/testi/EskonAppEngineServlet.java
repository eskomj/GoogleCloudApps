package fi.hatware.testi;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class EskonAppEngineServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
