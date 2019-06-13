package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejemplo8
 */
public class Ejemplo8 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejemplo8() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Example 8: Include</h2>");
		out.println("<ol>");
		out.println("<li>");
		out.println("	<p>Brasil</p>");
		RequestDispatcher rd = request.getRequestDispatcher("Ejemplo8B");
		rd.include(request, response);
		out.println("		</li>");
		out.println("		<li>");
		out.println("			<p>Alemania</p>");
		rd.include(request, response);
		out.println("		</li>");
		out.println("		<li>");
		out.println("			<p>Francia</p>");
		rd.include(request, response);
		out.println("		</li>");
		out.println("		<li>");
		out.println("			<p>España</p>");
		rd.include(request, response);
		out.println("		</li>");
		out.println("		<li>");
		out.println("			<p>Inglaterra</p>");
		rd.include(request, response);
		out.println("		</li>");
		out.println("		<li>");
		out.println("			<p>México</p>");
		rd.include(request, response);
		out.println("		</li>");
		out.println("		<li>");
		out.println("			<p>Italia</p>");
		rd.include(request, response);
		out.println("		</li>");
		out.println("	</ol>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
