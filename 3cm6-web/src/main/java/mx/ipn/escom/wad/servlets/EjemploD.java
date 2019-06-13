package mx.ipn.escom.wad.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.wad.bs.UsersBs;

/**
 * Servlet implementation class EjemploD
 */
public class EjemploD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UsersBs usersBs;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EjemploD() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer idUser = Integer.parseInt(request.getParameter("idUser"));
		usersBs.deleteUser(idUser);
		response.sendRedirect("EjemploB");
	}
}
