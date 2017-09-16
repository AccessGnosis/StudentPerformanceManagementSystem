/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: LoginedFilter.java
* Copyright 2017-06-12 By Gnosis. Allright reserved.
* Time: 下午3:46:52
*/
package cn.qingmukj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qingmukj.domain.UserBean;

public class LoginedFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession(true);

		if ((UserBean) session.getAttribute("user") == null || "".equals((UserBean) session.getAttribute("user"))) {
			// chain.doFilter(request, response);
			res.sendRedirect("../loginfailed.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
