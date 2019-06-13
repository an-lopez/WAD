package Filters;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mapping.User;
import util.ObjectSessionNames;

/**
 * Servlet Filter implementation class Filter2
 */
public class Filter2 implements Filter {
	Logger loggers = null;
	String[] privates = {"Ejercicio5", "index.jsp"};

	/**
	 * Default constructor.
	 */
	public Filter2() {
		
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, 
			ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		boolean flag = false;
		String permission = "ALLOWED";
		HttpServletRequest req = 
				(HttpServletRequest) request;
		
		
		User user = null;
		String[] uri = 
				req.getRequestURI().split("([/])");
		
		//Carpeta Privada
		for(String ur: uri) {
			if(ur.equals("interfaces"))
					flag = true;
		}
		
		//Recursos Privados
		for(String priv: privates) {
			if(uri[uri.length-1].equals(priv)) {
				flag = true;
			}
		}
		
		HttpSession session = req.getSession(false);
		if(session != null) {
			user = (User) session.getAttribute(ObjectSessionNames.USER);
		}
		
		if(user != null) {
			flag = false;
		}
		
		if(flag) {
			permission = "NOT ALLOWED";
			HttpServletResponse resp = 
					(HttpServletResponse) response;
			resp.sendError(404);
		}

		Date date = new Date();
		SimpleDateFormat sdf = 
				new SimpleDateFormat("dd/MM//yyyy");
		SimpleDateFormat sdf2 = 
				new SimpleDateFormat("HH:mm:ss");

		String logg = req.getRemoteAddr() + 
				" | " + sdf.format(date) +
				" | " + sdf2.format(date) + " | "
				+ req.getMethod() + " | " 
				+ req.getContextPath() 
				+ req.getServletPath() 
				+ " | "+permission;

		Logger.getAnonymousLogger().info(logg);
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
