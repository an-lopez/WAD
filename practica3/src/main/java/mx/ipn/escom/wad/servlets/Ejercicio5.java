package mx.ipn.escom.wad.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.wad.bs.AccessBs;
import mx.ipn.escom.wad.bs.AddressBs;
import mx.ipn.escom.wad.bs.UsersBs;
import mx.ipn.escom.wad.entidad.Access;
import mx.ipn.escom.wad.entidad.Address;
import mx.ipn.escom.wad.entidad.User;


@WebServlet("Ejercicio5")

/**
 * Servlet implementation class Ejercicio5
 */
public class Ejercicio5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsersBs usersBs;
	
	@Autowired
	private AddressBs addressBs;
	
	@Autowired
	private AccessBs accessBs;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio5() {
		super();
	}
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		SQLConnector.conexion();
//		String sql = "SELECT person.tx_first_name, person.tx_last_name_a, "
//				+ "person.tx_last_name_b, person.tx_curp, person.fh_birth, users.tx_login FROM users, person WHERE users.id_user = person.id_person";
//		ResultSet rs = SQLConnector.ejecutaQ(sql);
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<body>");
//		out.println("<table style=\"width:100%\">\n" + "  <tr>\n" + "    <th>First Name</th>\n"
//				+ "    <th>Lastname</th>\n" + "    <th>Second Lastname</th>\n" + "    <th>CURP</th>\n"
//				+ "    <th>Birthday</th>\n" + "    <th>Nickname</th>\n" + "  </tr>");
//		try {
//			while (rs.next()) {
//				out.println("<tr>");
//				out.println("<td>" + rs.getString(1) + "</td>\n" + "    <td>" + rs.getString(2) + "</td>\n" + "    <td>"
//						+ rs.getString(3) + "</td>\n" + "    <td>" + rs.getString(4) + "</td>\n" + "    <td>"
//						+ rs.getString(5) + "</td>\n" + "    <td>" + rs.getString(6) + "</td>");
//				out.println("</tr>");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		out.println("</table> ");
//		out.println("<form action=\"formulario.jsp\" method=post>\n" + "		<button type=\"submit\">New</button>\n"
//				+ "	</form>");
//		out.println("</body>");
//		out.println("</html>");
//		out.close();
//
//	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}					



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		String name = request.getParameter("uname");
		String lastName = request.getParameter("lname");
		String secondLastName = request.getParameter("lname2");

		String curp = request.getParameter("curp");
		
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String zipCode = request.getParameter("zipcode");

		String bd = request.getParameter("bd");
		String login = request.getParameter("login");
		String password = request.getParameter("pw");
		System.out.println("Birthday: " + bd);
		String[] birthday = bd.split("-");
		

		User user = new User();
		user.setName(name);
		user.setLastName(lastName);
		user.setSecondLastName(secondLastName);
		user.setCurp(curp);
		user.setBirthDay(new java.util.GregorianCalendar(Integer.parseInt(birthday[0]), Integer.parseInt(birthday[1]), Integer.parseInt(birthday[2])).getTime());
		user.setLogin(login);
		user.setPassword(password);
		
		usersBs.addUser(user);
		
		Address address = new Address();
		address.setId(user.getId());
		address.setCity(city);
		address.setStreet(street);
		address.setZipCode(zipCode);
		addressBs.addAddress(address);
		
		
		
		Access access = new Access();
		access.setId(user.getId());
		access.setAttempt(0);
		accessBs.addAccess(access);
		
	}

}
