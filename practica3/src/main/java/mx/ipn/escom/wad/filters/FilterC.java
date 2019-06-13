package mx.ipn.escom.wad.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FilterC
 */
public class FilterC implements Filter {

	/**
	 * Default constructor.
	 */
	public FilterC() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("Finalizando: FilterB");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filtrando petición: FilterC");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Inicializando: FilterC");
	}

}
