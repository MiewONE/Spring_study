package ser04.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncoderFilter
 */
@WebFilter("/*")
public class EncoderFilter1 implements Filter {

    /**
     * Default constructor. 
     */
    public EncoderFilter1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
//		chain.doFilter(req, res);
		System.out.println("doFilter »£√‚");
		req.setCharacterEncoding("utf-8");
		String context = ((HttpServletRequest)req).getContextPath();
		String pathinfo = ((HttpServletRequest)req).getRequestURI();
		String realPath = req.getRealPath(pathinfo);
		
		String mesg = "Context info :"+context
				+ "\n URI info : "+ pathinfo
				+ "\n Physical info :" + realPath ;
		System.out.println(mesg);
		chain.doFilter(req, res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
