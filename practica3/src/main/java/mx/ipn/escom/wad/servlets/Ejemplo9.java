package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejemplo9
 */
public class Ejemplo9 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Integer count=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo9() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer x=0;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Example 9: Concurrency</h2>");
		out.println("<h4>Contador global:" + count + "</h4>");
		out.println("<h4>Contador de petición:" + x + "</h4>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		x++;
		count++;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
