package database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logon
 */
public class logon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logon() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    String n=request.getParameter("uname");  
	    
	    SQLConnector.conexion();
	    String SQL = "SELECT person.tx_first_name, person.tx_last_name_a, "
	    		+ "person.tx_last_name_b FROM users, person WHERE users.tx_login = '" + n + "' "
				+ "AND users.id_user = person.id_person";
	    ResultSet rs = SQLConnector.ejecutaQ(SQL);
	    System.out.print(SQL);
	    try {
	    	rs.next();
			out.print("Welcome "+ rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}  
	          
	    out.close();  
	}

}
