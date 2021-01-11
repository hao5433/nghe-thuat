package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import service.VisitCountService;
import service.VisitCountServiceImp;
@WebFilter(urlPatterns = {"/*"})
public class ClickCounterFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	   VisitCountService visitCountService = new VisitCountServiceImp();
	   visitCountService.incrementCount();
	   chain.doFilter(request, response);
    

		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
