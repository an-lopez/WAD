package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.ipn.escom.wad.maping.Person;
import mx.ipn.escom.wad.util.ObjectSessionNames;

/**
 * Servlet implementation class EjemploAA
 */
public class EjemploAA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EjemploAA() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Ejemplo AA: Sessions</h2>");
		out.println("<h4>Session infromation:</h2>");
		out.println("<ul>");
		out.println("	<li>Creation time: " + new Date(session.getCreationTime()) + "</li>");
		out.println("	<li>Inactive interval: " + session.getMaxInactiveInterval() / 60 + "</li>");
		out.println("	<li>Id: " + session.getId() + "</li>");
		out.println("	<li>Id: " + new Date(session.getLastAccessedTime()) + "</li>");
		out.println("</ul>");
		Person person = (Person) session.getAttribute(ObjectSessionNames.PERSONA);
		out.println("<h4>Session Attributes:</h4>");
		out.println("<h5>Person object in session:</h5>");
		out.println("<ul>");
		out.println("	<li>Name: " + person.getName() + "</li>");
		out.println("	<li>Age: " + person.getAge() + "</li>");
		out.println("	<li>Phone: " + person.getPhone() + "</li>");
		out.println("</ul>");
		Enumeration<String> attributeNames = session.getAttributeNames();
		out.println("<h5>Session attributes 1:</h5>");
		out.println("<ul>");
		while (attributeNames.hasMoreElements()) {
			out.println("	<li>Attribute: " + attributeNames.nextElement() + "</li>");
		}
		out.println("</ul>");
		session.removeAttribute(ObjectSessionNames.PERSONA);
		attributeNames = session.getAttributeNames();
		out.println("<h5>Session attributes 2:</h5>");
		out.println("<ul>");
		while (attributeNames.hasMoreElements()) {
			out.println("	<li>Attribute: " + attributeNames.nextElement() + "</li>");
		}
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
