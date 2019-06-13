package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejemplo3
 */
public class Ejemplo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Integer parametro1;
	private Integer parametro2;
	private String parametro3;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejemplo3() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		parametro1 = Integer.valueOf(config.getInitParameter("parametro1"));
		parametro2 = Integer.valueOf(config.getInitParameter("parametro2"));
		parametro3 = config.getInitParameter("parametro3");
		System.out.println("parametro 1:" + parametro1);
		System.out.println("parametro 2:" + parametro1);
		System.out.println("parametro 3:" + parametro1);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
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
		out.println("<h2>Example3: Servlet init params</h2>");
		out.println("<ul>");
		out.println("<li>parametro 1:"+parametro1+"</li>");
		out.println("<li>parametro 2:"+parametro2+"</li>");
		out.println("<li>parametro 3:"+parametro3+"</li>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
