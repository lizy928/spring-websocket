package com.panda.socketprogramming.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 座席登录过滤器
 * 
 * @author Jiangsl
 *
 */
@Component
public class WebchatFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
			// CORS设置
			res.addHeader("Access-Control-Allow-Origin","*");
			res.addHeader("Access-Control-Allow-Credentials", "true");
			res.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,X-Pagination");
			res.addHeader("Access-Control-Allow-Methods", "*");
			res.addHeader("Access-Control-Expose-Headers", "X-Pagination");
		chain.doFilter(request, res);
		//chain.doFilter(new UserRequestWrapper(null, req), res);
	}

	@Override
	public void destroy() {
	}


}