package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.wad.bs.UsersBs;
import mx.ipn.escom.wad.entidad.User;

/**
 * Servlet implementation class EjemploC
 */
public class EjemploC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UsersBs userBs;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EjemploC() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Integer idUser = Integer.parseInt(request.getParameter("idUser"));
		User u = userBs.findById(idUser);
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>View User</h2>");

		out.println("<div>");
		out.println("<div>Name:</div>");
		out.println("<div>" + u.getName() + "</div>");
		out.println("</div>");

		out.println("<div>");
		out.println("<div>Last name:</div>");
		out.println("<div>" + u.getLastName() + "</div>");
		out.println("</div>");

		out.println("<div>");
		out.println("<div>Second last name</div>");
		out.println("<div>" + u.getSecondLastName() + "</div>");
		out.println("</div>");

		out.println("<div>");
		out.println("<div>CURP</div>");
		out.println("<div>" + u.getCurp() + "</div>");
		out.println("</div>");

		out.println("<div>");
		out.println("<div>Birthday</div>");
		out.println("<div>" + u.getBirthDay() + "</div>");
		out.println("</div>");

		out.println("<div>");
		out.println("<div>Login</div>");
		out.println("<div>" + u.getLogin() + "</div>");
		out.println("</div>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
