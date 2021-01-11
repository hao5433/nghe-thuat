package filter;

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

import model.User;

@WebFilter(urlPatterns = { "/user/*" })
public class UserFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpResp = (HttpServletResponse) response;
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession httpSession = httpReq.getSession();

		Object obj = httpSession.getAttribute("loginUser");
		if (obj != null && ((User) obj).getRole().equals("user"))
			chain.doFilter(request, response);
		else
			httpResp.sendRedirect("/sisionn4/signin");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
