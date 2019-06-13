package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * Servlet implementation class EjemploB
 */
public class EjemploB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UsersBs usersBs;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EjemploB() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		List<User> users = usersBs.findAllUsers();
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Users</h2>");
		out.println("<table>");
		out.println("	<thead>");
		out.println("<tr>");
		out.println("<th>First name</th>");
		out.println("<th>Last name</th>");
		out.println("<th>Second last name</th>");
		out.println("<th>CURP</th>");
		out.println("<th>Birth day</th>");
		out.println("<th>Nickname</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for (User user : users) {
			out.println("<tr>");
			out.println("<td>" + user.getName() + "</td>");
			out.println("<td>" + user.getLastName() + "</td>");
			out.println("<td>" + user.getSecondLastName() + "</td>");
			out.println("<td>" + user.getCurp() + "</td>");
			out.println("<td>" + user.getBirthDay() + "</td>");
			out.println("<td>" + user.getLogin() + "</td>");
			out.println("<td><a href=\"EjemploC?idUser=" + user.getId() + "\">View</a>"
					+ "<a href=\"EjemploD?idUser=" + user.getId() + "\">Delete</a>" + "</td>");
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
