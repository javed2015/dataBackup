package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter("/MyFilter")
public class MyFilter implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		int rows = 0;
		try {
			if ((req.getRequestURL().toString().endsWith("/VES_DEMO/index.jsp"))
					|| (req.getRequestURL().toString()
							.contains("/VES_DEMO/login"))
					|| (req.getRequestURL().toString()
							.contains("/VES_DEMO/scripts"))
					|| (req.getRequestURL().toString()
							.contains("/VES_DEMO/styles"))
					|| (req.getRequestURL().toString()
							.contains("/VES_DEMO/images"))
					|| (req.getRequestURL().toString()
							.endsWith("/VES_DEMO/reg.jsp"))
					|| (req.getRequestURL().toString()
							.endsWith("/VES_DEMO/registration.jsp"))
					|| (req.getRequestURL().toString()
							.endsWith("/VES_DEMO/Access/accessapprove.jsp"))
					|| (req.getRequestURL().toString()
							.endsWith("/VES_DEMO/Access/authenticate.jsp"))) {

				chain.doFilter(request, response);
				return;
			} else if ((request.getParameter("uname") != null)
					&& (request.getParameter("pass") != null)) {
				res.sendRedirect("login.jsp");
				return;
			} else if (session.getAttribute("userid") != null) {
				chain.doFilter(request, response);
				return;
			}

			else {
				req.getRequestDispatcher("index.jsp")
						.forward(request, response);
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
