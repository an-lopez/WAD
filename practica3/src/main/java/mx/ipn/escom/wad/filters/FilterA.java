package mx.ipn.escom.wad.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FilterA
 */
public class FilterA implements Filter {

    /**
     * Default constructor. 
     */
    public FilterA() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("Finalizando: FilterA");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Filtrando petición: FilterA");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Inicializando: FilterA");
	}

}
