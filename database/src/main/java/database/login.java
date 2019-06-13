package database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
		super();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("uname");
		String pw = request.getParameter("psw");

		SQLConnector.conexion();
		ResultSet rs = SQLConnector.ejecutaQ("SELECT * FROM users WHERE tx_login = '" + name + "'");

		try {
			if (rs.next()) {
				System.out.println(rs.getString(3));
				System.out.println(pw);
				if (rs.getString(3).equals(pw)) {
					System.out.println("Correcto");
					RequestDispatcher rd = request.getRequestDispatcher("logon");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("index.html");
					rd.include(request, response);
				}

			} else {
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.close();
	}

}
