package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejemplo2
 */
public class Ejemplo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo2() {
        super();
        System.out.println("---> Instanciando servlet: Ejemplo2");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("---> Inicializando servlet: Ejemplo2");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("---> Finalizando servlet: Ejemplo2");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Servlet lifecicle</h2>");
		out.println("</body>");
		out.println("</html>");
		System.out.println("---> Atendiendo peticion: Ejemplo2");
		out.close();
	}

}
