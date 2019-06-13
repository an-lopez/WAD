package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejemplo4
 */
public class Ejemplo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo4() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		String apple = request.getParameter("apple");
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Example 4: The HttpServletRequest ("+request.getMethod()+")</h2>");
		out.println("<ul>");
		out.println("<li>name:"+name+"</li>");
		out.println("<li>age:"+age+"</li>");
		out.println("<li>phone:"+phone+"</li>");
		out.println("<li>apple:"+apple+"</li>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
