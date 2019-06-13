package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.ipn.escom.wad.maping.Person;
import mx.ipn.escom.wad.util.ObjectSessionNames;

/**
 * Servlet implementation class EjemploA
 */
public class EjemploA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EjemploA() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		Integer age = Integer.parseInt(request.getParameter("age"));
		String phone = request.getParameter("phone");
		Person person = new Person(name, age, phone);
		HttpSession session = request.getSession(false);
		session.setAttribute(ObjectSessionNames.PERSONA, person);
		response.sendRedirect("EjemploAA");
	}

}
