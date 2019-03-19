package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejercicio4
 */
public class Ejercicio4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int counter = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int counter = 0;
		this.counter++;
		counter++;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Counter instancia: "+this.counter+"</h2>");
		out.println("<h2>Counter de GET: "+counter+"</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}

}
