package mx.ipn.escom.wad.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FilterD
 */
@WebFilter(urlPatterns = {"/*"})
public class FilterD implements Filter {

	/**
	 * Default constructor.
	 */
	public FilterD() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("Finalizando: FilterD");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filtrando petición: FilterD");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Inicializando: FilterD");
	}

}
