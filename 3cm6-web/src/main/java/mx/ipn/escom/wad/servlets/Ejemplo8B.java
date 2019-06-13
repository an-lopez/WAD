package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejemplo8B
 */
public class Ejemplo8B extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo8B() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("	<table>");
		out.println("		<thead>");
		out.println("			<tr>");
		out.println("				<th>Número</th>");
		out.println("				<th>Nombre</th>");
		out.println("			</tr>");
		out.println("		</thead>");
		out.println("		<tbody>");
		out.println("			<tr>");
		out.println("				<td>1</td>");
		out.println("				<td>Francisco paco memo ochoa</td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("			<td>10</td>");
		out.println("		<td>Ronaldinho gaucho</td>");
		out.println("				</tr>");
		out.println("			<tr>");
		out.println("					<td>5</td>");
		out.println("					<td>Zideni zidane</td>");
		out.println("				</tr>");
		out.println("				</tbody>");
		out.println("			</table>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
